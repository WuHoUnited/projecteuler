(ns projecteuler.problems.31)

(defn ways [[c & cs :as coins] amount]
  (cond (neg? amount) 0
        (zero? amount) 1
        (empty? coins) 0
        :else (+ (ways coins
                       (- amount c))
                 (ways cs amount))))

(defn problem-31
  ([]
   (problem-31 #{1 2 5 10 20 50 100 200} 200))
  ([coins amount]
   (ways (seq coins) amount)))

#_(problem-31)
