(ns projecteuler.problems.27
  (:require [projecteuler.library :as lib]))

(defn make-quadratic [a b]
  (fn [n]
    (+ (lib/square n)
       (* a n)
       b)))

(defn absolute-range [limit]
  (range (inc (- limit))
         limit))

(defn num-primes [f]
  (->> (range)
       (map f)
       (take-while lib/prime?)
       count))

(defn problem-27
  ([]
   (problem-27 1000 1000))
  ([a b]
   (->> (for [a (absolute-range a)
              b (absolute-range b)]
          [a b])
        (map (juxt identity (fn [[a b]]
                              (num-primes (make-quadratic a b)))))
        (apply max-key second)
        first
        lib/product)))

#_(problem-27)
