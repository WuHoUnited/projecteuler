(ns projecteuler.problems.48
  (:require [projecteuler.library :as lib]))

(defn problem-48
  ([]
   (problem-48 10 1000))
  ([digits n]
   (->> (range)
        rest
        (take n)
        (map #(lib/pow % %))
        (lib/sum)
        (lib/digits)
        (reverse)
        (take digits)
        (reverse)
        (apply str))))

#_(problem-48)
