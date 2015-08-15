(ns projecteuler.problems.6-test
  (:require [clojure.test :refer :all]
            [projecteuler.problems.6 :refer :all]))

(deftest problem-6-test
  (testing "Problem 6"
    (is (= (problem-6 100) 25164150))))
