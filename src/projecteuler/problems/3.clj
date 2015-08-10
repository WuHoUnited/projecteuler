(ns projecteuler.problems.3)

(defn divides [dividend divisor]
  (zero? (mod dividend divisor)))

(defn problem-3
  ([]
   (problem-3 600851475143))
  ([n]
   (loop [n n
          i 2]
     (cond (== n 1) i
           (divides n i) (recur (quot n i) i)
           :else (recur n (inc i))))))

#_(problem-3)
