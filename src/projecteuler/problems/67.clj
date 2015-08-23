(ns projecteuler.problems.67
  (:require [projecteuler.problems.library :as lib]))

(defn problem-67
  ([]
   (problem-67 "resources/67.txt"))
  ([file-path]
   (lib/maximum-triangle-sum file-path)))

#_(problem-67)
