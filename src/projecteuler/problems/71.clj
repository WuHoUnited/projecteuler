(ns projecteuler.problems.71
  (:require [projecteuler.library :as lib]))

(defn closest [target denom]
  (let [target-numerator (numerator target)
        target-denominator (denominator target)
        target-numer-times-denom (* target-numerator denom)
        is-evenly-divisible? (lib/divisible-by? target-numer-times-denom
                                                target-denominator)
        best-less-than-or-equal (quot target-numer-times-denom
                                      target-denominator)
        best-less-than (if is-evenly-divisible?
                         (dec best-less-than-or-equal)
                         best-less-than-or-equal)]
    (/ best-less-than denom)))

(defn problem-71
  ([]
   (problem-71 3/7 1e6))
  ([frac max-denom]
   (->> (range 1 (inc max-denom))
        (map (partial closest frac))
        (apply max)
        numerator)))

#_(problem-71)
