(ns s3bench.benchmark
  (:require [s3bench.s3 :as s3])
  (:require [s3bench.stats :as stats])
  (:require [s3bench.report :as reporter])
  (:require [clojure.tools.logging :as logger])
  (:require [clojure.core.async :as async :refer [go-loop <!! >! timeout chan alt! close! thread]]))

(defn- run-worker
  [worker-id bucket-name file-size terminate-ch]
  (let [wait-ch (chan)]
    (go-loop [idx 0]
      (let [filename (format "test-%d" idx)
            start-at (System/currentTimeMillis)]
        (alt! terminate-ch (close! wait-ch)
              :default ;(thread
              (try (s3/put-random-object bucket-name filename file-size)
                   (dosync
                    (alter stats/intermediate-latencies conj (- (System/currentTimeMillis) start-at))
                    (alter stats/intermediate-written-bytes conj file-size))
                   (catch Exception e
                     (swap! inc stats/err-count)))))
      (recur (inc idx)))
    wait-ch))

(defn- run-reporter
  [terminate-ch]
  (go-loop [time 1]
    (alt!
      terminate-ch
      (logger/info "[-] Shutdown reporter ...")
      [(timeout 1000)]
      (when-let [written-bytes-snapshot @stats/intermediate-written-bytes]
        (dosync
         (let [latency-snapshot @stats/intermediate-latencies
               written-bytes (apply + written-bytes-snapshot)]
           (alter stats/intermediate-latencies empty)
           (swap! stats/latencies conj latency-snapshot)
           (alter stats/intermediate-written-bytes empty)
           (swap! stats/written-bytes conj written-bytes-snapshot)
           (swap! stats/throughputs conj written-bytes)
           (reporter/report-intermediate-stats time (int written-bytes) latency-snapshot)))
        (recur (inc time))))))

(defn run-benchmark
  "Run benchmark process"
  [thread-count bucket-name time-limit file-size]
  (let [start-at (System/currentTimeMillis)
        terminate-ch (chan)
        wait-chs []]
    (logger/info "[!] Start benchmarking !!")
    (doseq [worker-id (range thread-count)]
      (conj wait-chs (run-worker worker-id bucket-name file-size terminate-ch)))
    (run-reporter terminate-ch)

    (<!! (timeout (* time-limit 1000)))
    (logger/info "[-] Shutdown workers ...")
    (close! terminate-ch)
    (doseq [wait-ch wait-chs] (<!! wait-ch))

    (let [latencies (flatten @stats/latencies)
          written-bytes (flatten @stats/written-bytes)
          elapsed-sec (Math/ceil (/ (- (System/currentTimeMillis) start-at) 1000))]
      (reporter/report-final-stats written-bytes elapsed-sec latencies)))
  (reporter/dump-csv-stats))
