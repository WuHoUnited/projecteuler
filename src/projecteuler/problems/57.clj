(ns projecteuler.problems.57
  (:require [projecteuler.library :as lib]))

(defn generate-expansions []
  (->> (iterate (fn [tail]
                  (/ (+ 2 tail)))
                1/2) 
       (map inc)))

(def num-digits
  (comp count lib/digits))

(defn numerator-longer-than-denominator? [frac]
  (> (num-digits (numerator frac))
     (num-digits (denominator frac))))

(defn problem-57 [n]
  (->> (generate-expansions)
       (take n)
       (filter numerator-longer-than-denominator?)
       count))

#_(problem-57 1000)
