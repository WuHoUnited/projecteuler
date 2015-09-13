(ns projecteuler.problems.58
  (:require [projecteuler.library :as lib]))

(defn square-corners [side]
  (let [max-corner (lib/square side)
        side-minus-one (dec side)]
    (->> max-corner
         (iterate #(- % side-minus-one))
         (take 4))))

(defn problem-58
  ([]
   (problem-58 1/10))
  ([target]
   (reduce (fn [{:keys [total-primes total-n]}
                new-side]
             (let [new-corners (square-corners new-side)
                   new-total-n (+ total-n
                                  (count new-corners))
                   new-primes-count (->> new-corners
                                         (filter lib/prime?)
                                         count)
                   new-total-primes (+ total-primes new-primes-count)]
               (if (< (/ new-total-primes new-total-n) target)
                 (reduced new-side)
                 {:total-primes new-total-primes
                  :total-n new-total-n})))
           {:total-primes 0
            :total-n 1}
           (iterate (partial + 2) 3))))

#_(problem-58)
