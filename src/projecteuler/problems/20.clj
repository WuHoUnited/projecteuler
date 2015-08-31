(ns projecteuler.problems.20
  (:require [projecteuler.library :as lib]))

(defn problem-20
  ([]
   (problem-20 100))
  ([n]
   (->> n
        lib/factorial
        lib/digits
        lib/sum)))

#_(problem-20)
