(ns s3bench.config
  (:require clojure.java.io)
  (:require [clojure.java.io :as io])
  (:import (java.util Properties)))

(defn- load-properties [file-name]
  (with-open [r (clojure.java.io/reader file-name)]
    (let [props (Properties.)]
      (.load props r)
      (into {} (for [[k v] props] [(keyword k) (read-string v)])))))

(defn- config []
  (if-let [property-file (clojure.java.io/resource "s3bench.properties")]
    (load-properties property-file)
    (load-properties (clojure.java.io/resource "s3bench.properties.example"))))

(def s3-creds
  (let [conf (config)]
    {:access-key (:s3.accessKey conf)
     :secret-key (:s3.secretKey conf)
     :endpoint (:s3.endpoint conf)}))

(def out-file-path
  (let [conf (config)
        dir (-> conf :bench.reportDir)
        date-fmt (java.text.SimpleDateFormat. "yyyy-MM-dd_H-M-S")
        date-str (.format date-fmt (new java.util.Date))
        filename (format "%s.csv" date-str)]
    (-> (io/file dir filename) .toString)))