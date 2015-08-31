(ns projecteuler.problems.29
  (:require [projecteuler.library :as lib]))

(defn problem-29
  ([]
   (problem-29 100 100))
  ([a-max b-max]
   (->> (for [a (range 2 (inc a-max))
              b (range 2 (inc b-max))]
          (lib/pow a b))
        (into #{})
        count)))

#_(problem-29)
