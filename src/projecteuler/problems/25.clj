(ns projecteuler.problems.25
  (:require [projecteuler.library :as lib]))

(defn problem-25
  ([]
   (problem-25 1000))
  ([num-digits]
   (->> lib/fibs
        (map-indexed (fn [i fib]
                       [(inc i) (-> fib lib/digits count)]))
        (drop-while (fn [[_ digs]]
                      (< digs num-digits)))
        ffirst)))

#_(problem-25)
