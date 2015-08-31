(ns projecteuler.problems.6
  (:require [projecteuler.library :as lib]))

(defn sum-of-squares [coll]
  (->> coll
       (map lib/square)
       lib/sum))

(defn square-of-sums [coll]
  (->> coll
       lib/sum
       lib/square))

(defn problem-6
  ([]
   (problem-6 100))
  ([n]
   (let [nums (range 1 (inc n))]
     (- (square-of-sums nums)
        (sum-of-squares nums)))))

#_(problem-6)
