(ns projecteuler.problems.22
  (:require [projecteuler.problems.library :as lib]))

(defn char-score [c]
  (inc (- (int c)
          (int \A))))

(defn name-score [string]
  (->> string
       (map char-score)
       lib/sum))

(defn problem-22
  ([]
   (problem-22 "resources/22.txt"))
  ([file-path]
   (->> file-path
        slurp
        (#(str "[" % "]"))
        read-string
        sort
        (map name-score)
        (map-indexed (fn [index name]
                       (* (inc index)
                          name)))
        lib/sum)))

#_(problem-22)
