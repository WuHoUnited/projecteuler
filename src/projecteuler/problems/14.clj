(ns projecteuler.problems.14)

(defn collatz-step [n]
  (if (even? n)
    (quot n 2)
    (inc (* n 3))))

(def collatz
  (memoize
   (fn [n]
     (if (== 1 n)
       '(1)
       (conj (collatz (collatz-step n))
             n)))))

(defn problem-14
  ([]
   (problem-14 1e6))
  ([limit]
   (->> (range 1 limit)
        (map collatz)
        (map (juxt identity count))
        (apply max-key second)
        ffirst)))

#_(problem-14)
