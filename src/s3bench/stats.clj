(ns s3bench.stats
  (:require [clojure.tools.logging :as logger]))

; Statistics

(def intermediate-latencies (ref ()))

(def latencies (atom ()))

(def intermediate-written-bytes (ref ()))

(def written-bytes (atom ()))

(def throughputs (atom ()))

(def err-count (atom 0))

; calculate functions

(defn calc-avg
  [values]
  (let [sum (apply + values)
        length (count values)]
    (/ sum (double length))))

(defn calc-min
  [values]
  (double (apply min values)))

(defn calc-max
  [values]
  (double (apply max values)))

(defn calc-percentile-n
  [values percent]
  {:pre [(> (count values) 0) (or (> percent 0) (<= percent 100))]}
  (let [size (count values)
        sorted-values (sort values)]
    (if (= size 1)
      (double (first sorted-values))
      (let [fp-idx (* (double size) (/ percent 100))
            int-idx (int fp-idx)]
        (cond
          (= fp-idx (double int-idx))
          (double (nth sorted-values (- int-idx 1)))
          (> fp-idx 1)
          (calc-avg [(nth sorted-values (- int-idx 1)) (nth sorted-values int-idx)])
          :else
          (double (nth sorted-values 0)))))))

(defn calc-throughput
  [write-bytes elapsed-sec]
  (/ (apply + write-bytes) (double elapsed-sec)))

(defn calc-variance
  [values]
  (let [avg (calc-avg values)
        length (count values)
        deviations (map #(Math/pow (- % avg) 2.0) values)]
    (/ (apply + deviations) (double length))))

(defn calc-stddev
  [values]
  (let [variance (calc-variance values)]
    (Math/pow variance 0.5)))
