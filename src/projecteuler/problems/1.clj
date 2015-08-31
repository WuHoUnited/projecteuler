(ns projecteuler.problems.1
  (:require [projecteuler.library :as lib]))

(defn problem-1
  ([]
   (problem-1 [3 5] 1000))
  ([divisors limit]
   (->> (range limit)
        (filter #(lib/divides-some? % divisors))
        lib/sum)))

#_(problem-1)
