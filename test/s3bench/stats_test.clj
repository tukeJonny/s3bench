(ns s3bench.stats-test
  (:require [clojure.test :refer :all]
            [s3bench.stats :refer :all]))

(deftest calc-avg-test
  (testing "basic"
    (let [test-data (sequence [1 2 3 4 5])
          got (calc-avg test-data)
          want 3.0]
      (is (= got want))))

  (testing "double"
    (let [test-data (sequence [1 1 3 4 5])
          got (calc-avg test-data)
          want 2.8]
      (is (= got want)))))

(deftest calc-percentile-n-test
  (testing "testcase1"
    (let [test-data [43 54 56 61 62 66]
          got (calc-percentile-n test-data 90)
          want 64.0]
      (is (= got want))))
  (testing "testcase2"
    (let [test-data [43]
          got (calc-percentile-n test-data 90)
          want 43.0]
      (is (= got want))))
  (testing "testcase3"
    (let [test-data [1 2 3 4 5 6 7 8 9 10]
          got (calc-percentile-n test-data 99.9)
          want 9.5]
      (is (= got want))))
  (testing "testcase4"
    (let [test-data [1 2 3 4 5 6 7 8 9 10]
          got (calc-percentile-n test-data 100)
          want 10.0]
      (is (= got want)))))
