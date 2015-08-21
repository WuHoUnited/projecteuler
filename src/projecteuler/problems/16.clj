(ns projecteuler.problems.16
  (:require [projecteuler.problems.library :as lib]))

(defn problem-16
  ([]
   (problem-16 2 1000))
  ([base exponent]
   (->> (lib/pow base exponent)
        lib/digits
        lib/sum)))

#_(problem-16)
