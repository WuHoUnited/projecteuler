(ns projecteuler.problems.6)

(defn square [n]
  (* n n))

(def sum
  (partial apply +))

(defn sum-of-squares [coll]
  (->> coll
       (map square)
       sum))

(defn square-of-sums [coll]
  (->> coll
       sum
       square))

(defn problem-6
  ([]
   (problem-6 100))
  ([n]
   (let [nums (range 1 (inc n))]
     (- (square-of-sums nums)
        (sum-of-squares nums)))))

#_(problem-6)
