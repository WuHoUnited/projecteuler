(ns projecteuler.problems.35
  (:require [projecteuler.problems.library :as lib]))

(defn rotate-coll [coll]
  (as-> coll it
    (cons (last it) coll)
    (butlast it)))

(defn get-rotations [coll]
  (let [length (count coll)]
    (->> coll
         (iterate rotate-coll)
         (take length))))

(defn get-rotations-number [n]
  (->> n
       lib/digits 
       get-rotations
       (map (partial apply str))
       (map read-string)))

(defn contains-zero? [n]
  (contains? (set (lib/digits n)) 0))

(defn circular-prime? [prime]
  (->> prime
       get-rotations-number
       rest
       (every? lib/prime?)))

(defn problem-35
  ([]
   (problem-35 1e6))
  ([limit]
   (->> lib/primes
        (take-while #(< % limit))
        (filter (complement contains-zero?))
        (filter circular-prime?)
        count)))

#_(problem-35)
