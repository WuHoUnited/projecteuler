(ns projecteuler.problems.41
  (:require [projecteuler.library :as lib]))

(def limit
  "This is the largest value we have to check.
  We know that it can be at most 7 digits because all pandigital
  8 and 9 digit numbers are divisible by 3 because the sum of their digits
  is divisible by 3 and therefore not prime."
  (dec (lib/pow 10 7)))

(defn pandigital? [n]
  (let [digs (lib/digits n)]
    (= (sort digs)
       (range 1 (inc (count digs))))))

(defn problem-41 []
  (->> (range limit 1 -2)
       (filter #(and (pandigital? %)
                     (lib/prime? %)))
       first))

#_(problem-41)
