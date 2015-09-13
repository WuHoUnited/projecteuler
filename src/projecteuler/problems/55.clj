(ns projecteuler.problems.55
  (:require [projecteuler.library :as lib]))

(defn reverse-and-add [n]
  (+' n
      (lib/reverse-int n)))

(defn lychrel-predicate [iterations]
  (fn [n]
    (->> n
         (iterate reverse-and-add)
         rest
         (take iterations)
         (map lib/digits)
         (filter lib/palindrome?)
         empty?)))

(defn problem-55
  ([]
   (problem-55 50 1e4))
  ([lychrel-bound max-n]
   (->> (range max-n)
        (filter (lychrel-predicate 50))
        count)))

#_(problem-55)
