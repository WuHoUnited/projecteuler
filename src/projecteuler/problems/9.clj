(ns projecteuler.problems.9
  (:require [projecteuler.library :as lib]))

(defn potential-a-b-c [limit]
  (for [a (range 1 limit)
        b (iterate inc (inc a))
        :let [c (- limit a b)]
        :while (< 0 a b c (inc limit))]
    [a b c]))

(defn problem-9
  ([]
   (problem-9 1000))
  ([n]
   (->> (potential-a-b-c n)
        (filter (partial apply lib/pythagorean?))
        first
        lib/product)))

#_(problem-9)
