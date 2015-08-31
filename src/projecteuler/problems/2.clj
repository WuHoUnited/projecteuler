(ns projecteuler.problems.2
  (:require [projecteuler.library :as lib]))

(defn problem-2
  ([]
   (problem-2 4e6))
  ([n]
   (->> lib/fibs
        (take-while #(<= % n))
        (filter even?)
        lib/sum)))

#_(problem-2)
