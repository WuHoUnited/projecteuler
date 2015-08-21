(ns projecteuler.problems.12
  (:require [projecteuler.problems.library :as lib]))

(defn divisors [n]
  (->> (range 1 (inc n))
       (filter (partial lib/divisible-by? n))))

(def triangle-numbers
  (->> (range)
       rest
       (reductions +)))

(defn problem-12
  ([]
   (problem-12 500))
  ([n]
   (->> triangle-numbers
        (filter #(< n (-> % divisors count)))
        first)))

#_(problem-12 500)

;; We're going to have to do this with prime factors and combinations
;; instead of how it's currently being done

