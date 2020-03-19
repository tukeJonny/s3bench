(ns s3bench.s3
  (:require [clojure.tools.logging :as logger])
  (:require [aws.sdk.s3 :as s3])
  (:require [s3bench.config :as config])
  (:require [s3bench.random :as random]))

(defn list-objects
  [bucket-name]
  (s3/list-objects config/s3-creds bucket-name))

(defn get-object
  [bucket-name file-name]
  (s3/get-object config/s3-creds bucket-name file-name))

(defn get-object-content
  [bucket-name file-name]
  (slurp (:content (get-object bucket-name file-name))))

(defn put-object
  [bucket-name file-name content]
  (s3/put-object config/s3-creds bucket-name file-name content))

(defn put-random-object
  [bucket-name file-name content-length]
  (let [content (random/gen-content content-length)]
    (put-object bucket-name file-name content)))

(defn delete-object
  [bucket-name file-name]
  (s3/delete-object config/s3-creds bucket-name file-name))

(defn delete-all-objects
  [bucket-name]
  (let [objects (-> bucket-name list-objects :objects)]
    (doseq [file-name (map :key objects)]
      (delete-object bucket-name file-name))))