(ns projecteuler.problems.26)

(defn index-of [item coll]
  (loop [[c & cs :as coll] coll
         index 0]
    (if coll
      (if (= c item)
        index
        (recur cs (inc index))))))

(defn repeat-length [divisor]
  (loop [remainder 1
         remainders-set #{1}
         remainders '(1)]
    (let [new-remainder (mod (* 10 remainder)
                             divisor)]
      (if (contains? remainders-set new-remainder)
        (inc (index-of new-remainder remainders))
        (recur new-remainder
               (conj remainders-set new-remainder)
               (conj remainders new-remainder))))))

(defn problem-26
  ([]
   (problem-26 1000))
  ([limit]
   (->> (range 2 limit)
        (map (juxt identity repeat-length))
        (apply max-key second)
        first)))

#_(problem-26)
