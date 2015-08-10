(ns projecteuler.problems.1-test
  (:require [clojure.test :refer :all]
            [projecteuler.problems.1 :refer :all]))

(deftest problem-1-test
  (testing "Problem 1"
    (is (= (problem-1 [3 5] 1000) 233168))))
