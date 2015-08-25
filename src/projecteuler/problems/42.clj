(ns projecteuler.problems.42
  (:require [projecteuler.problems.library :as lib]))

(defn triangle-numbers []
  (->> (range)
       rest
       (reductions +)))

(defn triangle-number? [n]
  (->> (triangle-numbers)
       (drop-while #(< % n))
       first
       (== n)))

(defn char-index [character]
  (inc (- (int character)
          (int \A))))

(defn word-value [word]
  (->> word
       (map char-index)
       lib/sum))

(defn problem-42
  ([]
   (problem-42 "resources/42.txt"))
  ([file-path]
   (->> file-path
        slurp
        (#(str "[" % "]"))
        read-string
        (map word-value)
        (filter triangle-number?)
        count)))

#_(problem-42)
