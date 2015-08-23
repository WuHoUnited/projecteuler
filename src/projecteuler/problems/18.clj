(ns projecteuler.problems.18
  (:require [projecteuler.problems.library :as lib]))

(defn problem-18
  ([]
   (problem-18 "resources/18.txt"))
  ([file-path]
   (lib/maximum-triangle-sum file-path)))

#_(problem-18)
