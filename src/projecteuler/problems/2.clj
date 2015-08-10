(ns projecteuler.problems.2)

(def fibs
  (lazy-cat [1 2]
            (map + fibs (rest fibs))))

(defn problem-2
  ([]
   (problem-2 4e6))
  ([n]
   (->> fibs
        (take-while #(<= % n))
        (filter even?)
        (apply +))))

#_(problem-2)
