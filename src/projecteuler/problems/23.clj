(ns projecteuler.problems.23
  (:require [projecteuler.library :as lib]))

(def abundant?
  (memoize
   (fn [n]
     (> (lib/divisor-sum n) n))))

(def abundant-numbers
  (filter abundant? (range)))

(defn sum-of-abundants? [n]
  (->> abundant-numbers
       (take-while #(< % n))
       (some (fn [abundant]
               (if (abundant? (- n abundant))
                 abundant)))))

(defn problem-23
  ([]
   (problem-23 28123))
  ([limit]
   (->> limit
        inc
        range
        (filter (complement sum-of-abundants?))
        lib/sum)))

#_(problem-23)
