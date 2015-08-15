(ns projecteuler.problems.7)

(defn divisible-by? [dividend divisor]
  (zero? (mod dividend divisor)))

(defn divides-some? [dividend divisors]
  (->> divisors
       (some (partial divisible-by? dividend))
       some?))

(defn square [n]
  (* n n))

(declare prime?)

(def primes
  (lazy-cat [2 3]
            (->> (iterate (partial + 2) 5)
                 (filter prime?))))

(defn prime? [n]
  (->> primes
       (take-while #(<= (square %) n))
       (divides-some? n)
       not))

(defn problem-7
  ([]
   (problem-7 10001))
  ([n]
   (nth primes (dec n))))

(problem-7)
