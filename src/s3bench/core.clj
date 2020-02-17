(ns s3bench.core
  (:require clojure.tools.cli :refer [parse-opts])
  (:require [yaml.core :as yaml]))

(def cli-options
  [["-c" "--config CONFIG_FILE_PATH" "Path to the config file"
    :default "./resources/config.yaml"]]
  [["-t" "--threads THREADS" "Number of benchmarker threads"
    :default 1
    :parse-fn #(Integer/parseInt %)]]
  [["-s" "--size SIZE" "Object size [B] per each request"
    :default 1024
    :parse-fn #(Integer/parseInt %)]]

(defn load-config
  "Load configuration file (about s3 credentials)"
  [path]
  (yaml/from-file path))

(defn -main [& args]