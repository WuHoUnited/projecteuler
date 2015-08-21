(ns projecteuler.problems.13
  (:require [projecteuler.problems.library :as lib]
            [clojure.string :as string]))

(defn problem-13
  ([]
   (problem-13 "resources/13.txt" 10))
  ([file-path num-digits]
   (->> file-path
        slurp
        string/split-lines
        (map lib/to-int)
        lib/sum
        lib/digits
        (take num-digits)
        (apply str))))

#_(problem-13)
