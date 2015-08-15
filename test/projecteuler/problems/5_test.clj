(ns projecteuler.problems.5-test
  (:require [clojure.test :refer :all]
            [projecteuler.problems.5 :refer :all]))

(deftest problem-5-test
  (testing "Problem 5"
    (is (= (problem-5 20) 232792560))))
