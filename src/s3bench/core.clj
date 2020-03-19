(ns s3bench.core
  (:require [s3bench.config :as config])
  (:require [s3bench.random :as random])
  (:require [s3bench.s3 :as s3])
  (:require [s3bench.benchmark :as benchmark])
  (:require [s3bench.stats :as stats])
  (:require [clojure.tools.logging :as logger])
  (:require [clojure.tools.cli :refer [parse-opts]]))

(def cli-options
  [["-n" "--bucket-name BUCKETNAME" "target bucket name"
    :default "egawatest"]
   ["-c" "--concurrency CONCURRENCY" "Number of benchmarker threads"
    :default 4
    :parse-fn #(Integer/parseInt %)]
   ["-t" "--time-limit TIMELIMIT" "Timelimit for benchmarking"
    :default 15
    :parse-fn #(Integer/parseInt %)]
   ["-s" "--size SIZE" "Object size [B] per each request"
    :default 50
    :parse-fn #(Integer/parseInt %)]])

(defn -main [& args]
  (let [options (-> (parse-opts args cli-options) :options)
        bucket-name (:bucket-name options)
        concurrency (:concurrency options)
        time-limit (:time-limit options)
        size (:size options)]
    (benchmark/run-benchmark concurrency bucket-name time-limit size)
    (logger/info "[*] Cleaning objects ...")
    (s3/delete-all-objects bucket-name)
    (logger/info "[-] Shutdown s3bench.")))
