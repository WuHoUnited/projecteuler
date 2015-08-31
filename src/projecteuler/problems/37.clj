(ns projecteuler.problems.37
  (:require [projecteuler.problems.library :as lib]))

(defn heads
  [coll]
  (->> coll
       (iterate butlast)
       (take-while seq)))

(defn digits-to-number [digits]
  (reduce (fn [acc d]
            (+ (* acc 10)
               d))
          0
          digits))

(defn left-to-right-truncations [n]
  (->> n
       lib/digits
       lib/tails
       (map digits-to-number)))

(defn right-to-left-truncations [n]
  (->> n
       lib/digits
       heads
       (map digits-to-number)))

(defn left-to-right-truncatable-prime? [prime]
  (every? lib/prime? (rest (left-to-right-truncations prime))))

(defn right-to-left-truncatable-prime? [prime]
  (every? lib/prime? (rest (right-to-left-truncations prime))))

(defn truncatable-prime? [prime]
  (and (left-to-right-truncatable-prime? prime)
       (right-to-left-truncatable-prime? prime)))

(defn problem-37
  ([]
   (problem-37 11))
  ([n]
   (->> lib/primes
        (filter truncatable-prime?)
        (filter #(< 10 %))
        (take n)
        lib/sum)))

#_(problem-37)
