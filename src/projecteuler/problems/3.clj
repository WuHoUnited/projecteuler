(ns projecteuler.problems.3
  (:require [projecteuler.library :as lib]))

(defn problem-3
  ([]
   (problem-3 600851475143))
  ([n]
   (loop [n n
          i 2]
     (cond (== n 1) i
           (lib/divisible-by? n i) (recur (quot n i) i)
           :else (recur n (inc i))))))

#_(problem-3)
