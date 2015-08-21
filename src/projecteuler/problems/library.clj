(ns projecteuler.problems.library
  (:require [clojure.string :as str]))

(defn divisible-by?
  "Returns true if dividend is divisible by divisor"
  [dividend divisor]
  (zero? (mod dividend divisor)))

(defn divides-some?
  "Returns whether dividend is divisible by any of the divisors"
  [dividend divisors]
  (->> divisors
       (some (partial divisible-by? dividend))
       some?))

(defn digits
  "Returns the digits of n"
  [n]
  (let [chars (-> n str seq)]
    (map (fn [char]
           (read-string (str char)))
         chars)))

(defn square
  "Returns n squared"
  [n]
  (* n n))

(defn product
  "Returns the product of all xs"
  [xs]
  (apply * xs))

(defn sum
  "Returns the sum of xs"
  [xs]
  (apply + xs))

(defn palindrome?
  "Returns whether coll is a palindrome"
  [coll]
  (= (seq coll)
     (reverse coll)))

(defn pow
  "Raises base to exp exponent"
  [base exp]
  (loop [exp exp
         acc 1]
    (if (zero? exp)
      acc
      (recur (dec exp)
             (* acc base)))))

(defn gcd
  "Returns the greatest common divisor of x and y"
  [x y]
  (if (zero? y)
    x
    (recur y
           (mod x y))))

(defn lcm
  "Returns the least common multiple of x and by"
  [x y]
  (quot (* x y)
        (gcd x y)))

(def fibs
  "A lazy, ordered sequence of fibonacci numbers"
  (lazy-cat [1 2]
            (map + fibs (rest fibs))))

(declare prime?)

(def primes
  "A lazy, ordered sequence of all the prime numbers"
  (lazy-cat [2 3]
            (->> (iterate (partial + 2) 5)
                 (filter prime?))))

(defn prime?
  "Returns whether n is prime"
  [n]
  (->> primes
       (take-while #(<= (square %) n))
       (divides-some? n)
       not))

(defn pythagorean?
  "Returns whether a b c are the sides of a pythagorean triangle with
  c as the hypotenuse"
  [a b c]
  (== (+ (square a)
         (square b))
      (square c)))

(defn tails
  "Returns all the tails of a sequence"
  [coll]
  (->> coll
       (iterate rest)
       (take-while seq)))

(defn subseqs-of-length
  "Returns all subsequences of a coll that have length n"
  [n coll]
  (->> coll
       tails
       (map (partial take n))
       (filter (fn [seq]
                 (= n (count seq))))))

(defprotocol IToInt
  (to-int [x]))

(extend-protocol IToInt
  String
  (to-int [string]
    (let [trimmed (->> string
                       (drop-while #{\0})
                       (apply str))]
      (if (seq trimmed)
        (read-string trimmed)
        0))))
