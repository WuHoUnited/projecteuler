(ns projecteuler.problems.12
  (:require [projecteuler.library :as lib]))

(def triangle-numbers
  (->> (range)
       rest
       (reductions +)))

(defn problem-12
  ([]
   (problem-12 500))
  ([n]
   (->> triangle-numbers
        (filter #(< n (-> % lib/divisors count)))
        first)))

#_(problem-12 500)

;; We're going to have to do this with prime factors and combinations
;; instead of how it's currently being done

