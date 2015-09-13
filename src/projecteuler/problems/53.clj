(ns projecteuler.problems.53
  (:require [projecteuler.library :as lib]))

(defn nCr [n r]
  (quot
   (lib/factorial n)
   (*'
    (lib/factorial r)
    (lib/factorial (- n r)))))

(defn problem-53
  ([]
   (problem-53 100 1e6))
  ([max-n lower-bound]
   (->> (for [n (range 1 (inc max-n))
              r (range 1 (inc n))]
          (nCr n r))
        (filter #(> % lower-bound))
        count)))

#_(problem-53)
