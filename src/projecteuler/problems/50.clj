(ns projecteuler.problems.50
  (:require [projecteuler.problems.library :as lib]))

(defn max-prime-in-coll [coll]
  (->> coll
       (map-indexed #(vector %1 %2))
       (filter (comp lib/prime? second))
       last))

(defn best-length-for-primes [limit primes]
  (->> primes
       (reductions +)
       (take-while #(< % limit))
       max-prime-in-coll))

(defn problem-50
  ([]
   (problem-50 1e6))
  ([limit]
   (->> lib/primes
        (take-while #(< % limit))
        lib/tails
        (map (partial best-length-for-primes limit))
        (apply max-key first)
        second)))

#_(problem-50)
