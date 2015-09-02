(ns projecteuler.problems.49
  (:require [projecteuler.library :as lib]))

(defn get-n-digit-primes [n]
  (let [lower-bound (lib/pow 10 (dec n))
        upper-bound (* lower-bound 10)]
    (->> lib/primes
         (drop-while #(< % lower-bound))
         (take-while #(< % upper-bound)))))

(defn permutation? [x y]
  (let [sort-digits (comp sort lib/digits)]
    (= (sort-digits x)
       (sort-digits y))))

(defn get-arithmetic-permutables [[x1 & xs] coll-set]
  (->> xs
       (map (fn [x2]
              (if (permutation? x1 x2)
                (let [diff (- x2 x1)
                      x3 (+ x2 diff)]
                  (if (and (coll-set x3)
                           (permutation? x1 x3))
                    [x1 x2 x3])))))
       (filter identity)))

(defn find-arithmetic-permutable-primes [digits]
  (let [n-digit-primes (get-n-digit-primes digits)
        n-digit-primes-set (set n-digit-primes)]
    (->> n-digit-primes
         lib/tails
         (mapcat #(get-arithmetic-permutables % n-digit-primes-set)))))

(defn problem-49
  ([]
   (problem-49 [1487 4817 8147]))
  ([exclusion]
   (->> (find-arithmetic-permutable-primes 4)
        identity
        (remove #{exclusion})
        first
        (apply str)
        read-string)))

#_(problem-49)
