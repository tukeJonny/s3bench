(ns s3bench.report
  (:require [s3bench.stats :as stats])
  (:require [s3bench.config :as conf])
  (:require [clojure.data.csv :as csv])
  (:require [clojure.java.io :as io])
  (:require [clojure.tools.logging :as logger]))

(def ^:private csv-stats (atom ()))

(def ^:private intermediate-stats-fmt "%4d\t%7d\t%13.3f\t%13.3f\t%13.3f\t%10.3f\t%14.3f\t%14.3f\t%14.3f\t%14.3f\t%3d")

(defn report-intermediate-stats
  [time written-bytes latencies]
  {:pre [(> written-bytes 0) (> (count latencies) 0)]}
  (println "time\tsize[B]\tmax-lat[msec]\tmin-lat[msec]\tavg-lat[msec]\tstddev-lat\tlat(p25)[msec]\tlat(p50)[msec]\tlat(p75)[msec]\tlat(p99)[msec]\terr")
  (let [stats (array-map
               :time time
               :written-bytes written-bytes
               :max-latency (stats/calc-max latencies)
               :min-latency (stats/calc-min latencies)
               :avg-latency (stats/calc-avg latencies)
               :stddev-latency (stats/calc-stddev latencies)
               :p25-latency (stats/calc-percentile-n latencies 25)
               :p50-latency (stats/calc-percentile-n latencies 50)
               :p75-latency (stats/calc-percentile-n latencies 75)
               :p99-latency (stats/calc-percentile-n latencies 99)
               :err-count @stats/err-count)
        fmt-args (into [] (vals stats))]
    (swap! csv-stats conj stats)
    (println (apply format intermediate-stats-fmt fmt-args))))

(defn dump-csv-stats []
  (let [stats @csv-stats
        columns (into [] (keys (nth stats 0)))
        headers (map name columns)
        rows (mapv #(mapv % columns) stats)]
    (with-open [file (io/writer conf/out-file-path)]
      (csv/write-csv file (cons headers (reverse rows))))))

(def ^:private final-stats-fmt
  "========== Final Result ==========
Written: %d [Bytes]
Throughput:
    Total:           %.3f [Bytes/sec]
    Max:             %.3f [Bytes/sec]
    Min:             %.3f [Bytes/sec]
    Avg              %.3f [Bytes/sec]
    Stddev:          %.3f
    Percentile(25%%): %.3f [Bytes/sec]
    Percentile(50%%): %.3f [Bytes/sec]
    Percentile(75%%): %.3f [Bytes/sec]
    Percentile(99%%): %.3f [Bytes/sec]
Latency:
    Max:             %.3f [msec]
    Min:             %.3f [msec]
    Avg              %.3f [msec]
    Stddev:          %.3f
    Percentile(25%%): %.3f [msec]
    Percentile(50%%): %.3f [msec]
    Percentile(75%%): %.3f [msec]
    Percentile(99%%): %.3f [msec]
Err: %d
")

(defn report-final-stats
  [written-bytes elapsed-sec latencies]
  {:pre [(> (count written-bytes) 0) (> (count latencies) 0)]}
  (let [fmt-args [(apply + written-bytes)
                  (stats/calc-throughput written-bytes elapsed-sec)
                  (stats/calc-max @stats/throughputs)
                  (stats/calc-min @stats/throughputs)
                  (stats/calc-avg @stats/throughputs)
                  (stats/calc-stddev @stats/throughputs)
                  (stats/calc-percentile-n @stats/throughputs 25)
                  (stats/calc-percentile-n @stats/throughputs 50)
                  (stats/calc-percentile-n @stats/throughputs 75)
                  (stats/calc-percentile-n @stats/throughputs 99)
                  (stats/calc-max latencies)
                  (stats/calc-min latencies)
                  (stats/calc-avg latencies)
                  (stats/calc-stddev latencies)
                  (stats/calc-percentile-n latencies 25)
                  (stats/calc-percentile-n latencies 50)
                  (stats/calc-percentile-n latencies 75)
                  (stats/calc-percentile-n latencies 99)
                  @stats/err-count]]
    (println (apply format final-stats-fmt fmt-args))))

