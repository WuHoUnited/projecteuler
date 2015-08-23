(ns projecteuler.problems.21
  (:require [projecteuler.problems.library :as lib]))

(defn amicable? [n]
  (let [div-sum (lib/divisor-sum n)]
    (and (not= n div-sum)
         (== n (lib/divisor-sum div-sum)))))

(defn problem-21
  ([]
   (problem-21 1e5))
  ([limit]
   (->> (range 1 limit)
        (filter amicable?)
        lib/sum)))

#_(problem-21)

;; This implementation is likely correct however it runs slowly
;; It needs to be made quicker (most likely by implementing a faster lib/divisors)
