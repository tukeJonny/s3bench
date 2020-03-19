(ns s3bench.stats-test
  (:require [clojure.test :refer :all]
            [s3bench.random :refer :all]))

(deftest gen-content-test
  (testing "basic"
    (let [content-length 1024
          got (gen-content content-length)
          got-length (count got)]
      (is (= got-length content-length)))))