(ns projecteuler.problems.30
  (:require [projecteuler.problems.library :as lib]))

(defn sum-of-powers [power n]
  (->> n
      lib/digits
      (map #(lib/pow % power))
      lib/sum))

(defn num-is-sum-of-powers? [power n]
  (== n (sum-of-powers power n)))

(defn max-9-sum [power digits]
  (->> (repeat digits 9)
       (apply str)
       read-string
       (sum-of-powers power)))

(defn calculate-limit [power]
  (->> (iterate inc 1)
       (take-while #(>= (* % (lib/pow 9 power))
                        (lib/pow 10 %)))
       last 
       (max-9-sum power)
       inc))

(defn problem-30
  ([]
   (problem-30 5))
  ([power]
   (->> (range 2 (calculate-limit power)) 
        (filter (partial num-is-sum-of-powers? power))
        lib/sum)))

#_(problem-30)
