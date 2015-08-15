(ns projecteuler.problems.4
  (:require [clojure.string :as str]))

(defn palindrome? [x]
  (let [string (str x)]
    (= string
       (str/reverse string))))

(defn pow [base exp]
  (loop [exp exp
         acc 1]
    (if (zero? exp)
      acc
      (recur (dec exp)
             (* acc base)))))

(defn problem-4
  ([]
   (problem-4 3))
  ([digits]
   (let [min (pow 10 (dec digits))
         limit (* min 10)
         nums (range min limit)] 
     (->> (for [a nums
                b nums
                :let [product (* a b)]
                :when (palindrome? product)]
            product)
          sort
          last))))

#_(problem-4)
