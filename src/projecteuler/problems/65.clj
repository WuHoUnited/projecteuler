(ns projecteuler.problems.65
  (:require [projecteuler.library :as lib]))

(defn continued-fraction [head tail]
  (->> tail
       reverse
       (reduce (fn [acc next-val]
                 (/ (+ acc next-val)))
               0)
       (+ head)))

(defn e-tail []
  (->> (iterate inc 1)
       (mapcat (fn [i] [1 (+ i i) 1]))))

(defn problem-65 [n]
  (->> (continued-fraction 2 (take (dec n) (e-tail)))
       numerator
       lib/digits
       lib/sum))

#_(problem-65 100)
