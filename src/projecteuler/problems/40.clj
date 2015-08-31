(ns projecteuler.problems.40
  (:require [projecteuler.library :as lib]))

(defn champernown-digits []
  (->> (range)
       rest
       (mapcat lib/digits)))

(defn get-champernown-index [index]
  (nth (champernown-digits)
       (dec index)))

(defn problem-40
  ([]
   (problem-40 7))
  ([total-terms]
   (->> (range total-terms)
        (map (partial lib/pow 10))
        (map get-champernown-index)
        lib/product)))

#_(problem-40)
