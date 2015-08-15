(ns projecteuler.problems.9)

(defn potential-a-b-c [limit]
  (for [a (range 1 limit)
        b (iterate inc (inc a))
        :let [c (- limit a b)]
        :while (< 0 a b c (inc limit))]
    [a b c]))

(defn square [x]
  (* x x))

(defn pythagorean? [a b c]
  (== (+ (square a)
         (square b))
      (square c)))

(defn problem-9
  ([]
   (problem-9 1000))
  ([n]
   (->> (potential-a-b-c n)
        (filter (partial apply pythagorean?))
        first
        (apply *))))

#_(problem-9)
