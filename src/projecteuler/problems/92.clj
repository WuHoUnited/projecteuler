(ns projecteuler.problems.92)

;; This is considerably faster than using lib's digit functions
;; should be looking into improving the performance of the lib funcitons
(defn square-digits [n]
  (loop [n n
         acc 0]
    (if (zero? n)
      acc
      (let [ones (mod n 10)]
        (recur (quot n 10)
               (+ acc
                  (* ones ones)))))))

(defn eighty-nine-chain? [n]
  (cond
    (== 89 n) true
    (== 1 n) false
    :else (recur (square-digits n))))

(defn problem-92
  ([]
   (problem-92 1e7))
  ([limit]
   (->> (range 1 limit) 
        (filter eighty-nine-chain?)
        count)))

#_(problem-92)
