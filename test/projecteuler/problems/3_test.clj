(ns projecteuler.problems.3-test
  (:require [clojure.test :refer :all]
            [projecteuler.problems.3 :refer :all]))

(deftest problem-3-test
  (testing "Problem 3"
    (is (= (problem-3 600851475143) 6857))))
