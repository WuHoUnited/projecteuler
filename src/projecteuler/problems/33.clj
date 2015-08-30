(ns projecteuler.problems.33)

(defn to-num [tens ones]
  (+ (* 10 tens)
     ones))

(defn generate-fractions []
  (for [numerator-tens (range 1 10)
        numerator-ones (range 1 10)
        denominator-tens (range 1 10)
        denominator-ones (range 1 10)
        :let [numer (to-num numerator-tens numerator-ones)
              denom (to-num denominator-tens denominator-ones)
              frac (/ numer denom)]
        :when (< frac 1)
        :let [try-1 (/ numerator-tens denominator-ones)
              try-2 (/ numerator-ones denominator-tens)]
        :when (or (and (== numerator-ones denominator-tens)
                       (== frac try-1))
                  (and (== numerator-tens denominator-ones)
                       (== frac try-2)))]
    frac))

(defn problem-33
  ([]
   (->> (generate-fractions)
        (apply *)
        denominator)))

#_(problem-33)
