(ns projecteuler.problems.10
  (:require [projecteuler.problems.library :as lib]))

(defn problem-10
  ([] (problem-10 2e6))
  ([n]
   (->> lib/primes
        (take-while #(< % n))
        lib/sum)))

#_(problem-10)
