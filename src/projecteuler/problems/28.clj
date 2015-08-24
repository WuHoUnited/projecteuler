(ns projecteuler.problems.28
  (:require [projecteuler.problems.library :as lib]))

(defn sum-for-square [side]
  (if (== 1 side)
    1
    (let [largest (lib/square side)
          corners (->> largest
                       (iterate #(inc (- % side)))
                       (take 4))]
      (lib/sum corners))))

(defn problem-28
  ([]
   (problem-28 1001))
  ([side]
   (->> (range 1 (inc side))
        (filter odd?)
        (map sum-for-square)
        lib/sum)))

#_(problem-28)
