(ns projecteuler.problems.5
  (:require [projecteuler.library :as lib]))

(defn problem-5
  ([]
   (problem-5 20))
  ([n]
   (reduce lib/lcm 1 (range 1 n))))

#_(problem-5)
