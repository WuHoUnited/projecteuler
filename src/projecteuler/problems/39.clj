(ns projecteuler.problems.39
  (:require [projecteuler.problems.library :as lib]
            [clojure.math.numeric-tower :as math]))

(defn generate-triangles [perimeter-limit]
  (for [a (range 1 (quot perimeter-limit 2))
        b (iterate inc a)
        :while (<= (+ a b b) perimeter-limit)
        :let [[c rem] (math/exact-integer-sqrt (+ (lib/square a)
                                                  (lib/square b)))]
        :when (zero? rem)]
    [a b c]))

(defn problem-39
  ([]
   (problem-39 1000))
  ([limit]
   (->> (generate-triangles limit) 
        (map (partial apply +))
        frequencies
        (apply max-key second)
        first)))

#_(problem-39)
