(ns projecteuler.problems.8
  (:require [projecteuler.problems.library :as lib]))

(defn problem-8
  ([]
   (problem-8 13 "resources/8.txt"))
  ([length file-path]
   (->> file-path
        slurp
        read-string
        lib/digits
        (lib/subseqs-of-length length)
        (map lib/product)
        (apply max))))

#_(problem-8)
