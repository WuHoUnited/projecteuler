(ns projecteuler.problems.4-test
  (:require [clojure.test :refer :all]
            [projecteuler.problems.4 :refer :all]))

(deftest problem-4-test
  (testing "Problem 4"
    (is (= (problem-4 3) 906609))))
