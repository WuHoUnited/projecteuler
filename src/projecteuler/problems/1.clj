(ns projecteuler.problems.1)

(defn divisible-by? [number test]
  (zero? (mod number test)))

(defn divides-some [numbers n]
  (some (fn [num]
          (divisible-by? n num))
        numbers))

(defn problem-1
  ([]
   (problem-1 [3 5] 1000))
  ([divisors limit]
   (->> (range limit)
        (filter (partial divides-some divisors))
        (apply +))))

#_(problem-1)
