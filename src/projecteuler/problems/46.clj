(ns projecteuler.problems.46
  (:require [projecteuler.library :as lib]))

(defn odd-composites []
  (->> (iterate (partial + 2) 3)
       (filter (complement lib/prime?))))

(defn squares []
  (map lib/square (range)))

(defn twice-squares []
  (map (partial * 2) (squares)))

(defn sorted-list-contains? [x coll]
  (->> coll
       (drop-while #(< % x))
       first
       (= x)))

(defn sum-of-pair? [n xs ys]
  (->> xs
       (take-while #(< % n))
       (some (fn [x]
               (sorted-list-contains? (- n x) ys)))
       some?))

(defn problem-46
  ([]
   (problem-46 0))
  ([n]
   (let [twice-sqs (twice-squares)]
     (as-> (odd-composites) it
       (filter (complement #(sum-of-pair? % twice-sqs lib/primes)) it)
       (nth it n)))))

#_(problem-46)
