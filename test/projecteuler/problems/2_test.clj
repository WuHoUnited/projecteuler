(ns projecteuler.problems.2-test
  (:require [clojure.test :refer :all]
            [projecteuler.problems.2 :refer :all]))

(deftest problem-2-test
  (testing "Problem 2"
    (is (= (problem-2 4e6) 4613732))))
