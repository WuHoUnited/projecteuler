(ns projecteuler.problems.7-test
  (:require [clojure.test :refer :all]
            [projecteuler.problems.7 :refer :all]))

(deftest problem-7-test
  (testing "Problem 7"
    (is (= (problem-7 10001) 104743))))
