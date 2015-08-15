(ns projecteuler.problems.5)

(defn gcd [a b]
  (if (zero? b)
    a
    (recur b
           (mod a b))))

(defn lcm [a b]
  (quot (* a b)
        (gcd a b)))

(defn problem-5
  ([]
   (problem-5 20))
  ([n]
   (reduce lcm 1 (range 1 n))))

(problem-5)
