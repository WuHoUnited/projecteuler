(ns projecteuler.problems.4
  (:require [projecteuler.library :as lib]))

(defn problem-4
  ([]
   (problem-4 3))
  ([digits]
   (let [min (lib/pow 10 (dec digits))
         limit (* min 10)
         nums (range min limit)] 
     (->> (for [a nums
                b nums
                :let [product (* a b)]
                :when (lib/palindrome? (str product))]
            product)
          sort
          last))))

#_(problem-4)
