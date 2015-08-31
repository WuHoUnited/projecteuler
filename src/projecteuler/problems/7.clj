(ns projecteuler.problems.7
  (:require [projecteuler.library :as lib]))

(defn problem-7
  ([]
   (problem-7 10001))
  ([n]
   (nth lib/primes (dec n))))

#_(problem-7)
