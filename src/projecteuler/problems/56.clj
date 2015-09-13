(ns projecteuler.problems.56
  (:require [projecteuler.library :as lib]))

(defn digital-sum [n]
  (->> n
       lib/digits
       lib/sum))

(defn problem-56
  ([]
   (problem-56 100))
  ([limit]
   (->> (for [a (range limit)
              b (range limit)]
          (lib/pow a b))
        (map digital-sum)
        (apply max))))

#_(problem-56)
