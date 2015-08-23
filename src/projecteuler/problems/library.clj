(ns projecteuler.problems.library
  (:require [clojure.string :as string]))

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
             (*' acc base)))))

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
  (lazy-cat [1 1]
            (map +' fibs (rest fibs))))

(declare prime?)

(def primes
  "A lazy, ordered sequence of all the prime numbers"
  (lazy-cat [2 3]
            (->> (iterate (partial + 2) 5)
                 (filter prime?))))

(defn prime?
  "Returns whether n is prime"
  [n]
  (and (< 1 n)
       (->> primes
            (take-while #(<= (square %) n))
            (divides-some? n)
            not)))

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
  "Protocol for things which can be converted to integers"
  (to-int [this] "converts this to an integer"))

(extend-protocol IToInt
  String
  (to-int [string]
    (let [trimmed (->> string
                       (drop-while #{\0})
                       (apply str))]
      (if (seq trimmed)
        (read-string trimmed)
        0))))

(defn factorial
  "Calculates the factorial of n"
  [n]
  (reduce *' (range 1 (inc n))))


(defn words
  "Returns a sequence of the words of string.
  A word is composed of characters separated by whitespace"
  [string]
  (re-seq #"\S+" string))

(defn load-ints-2d
  "Returns a 2-dimensional sequence of integers which are stored in file-location"
  [file-location]
  (->> file-location
       slurp
       string/split-lines
       (map words)
       (map #(map to-int %))))

(defn- calculate-maximum-triangle-sum
  "Calculates the maximum sum from top-bottom in a triangle as per problem 18.
  triangle must be a 2-dimensional sequence of numbers with the top of the
  triangle being first"
  [triangle]
  (->> triangle
       reverse
       (reduce (fn [previous-sums row]
                 (map-indexed
                  (fn [index value]
                    (+ value (max (nth previous-sums index)
                                  (nth previous-sums (inc index)))))
                  row))
               (repeat 0))
       first))

(defn maximum-triangle-sum
  "Calculates the maximum sum from top-bottom in a triangle as per problem 19.
  file-path must contain the contents of a triangle as provided by project euler."
  [file-path]
  (->> file-path
       load-ints-2d
       calculate-maximum-triangle-sum))

(defn divisors
  "The divisors of n, sorted from smallest to largest. Includes n itself."
  [n]
  (->> (range 1 (inc n))
       (filter (partial divisible-by? n))))

(def divisor-sum
  "The sum of divisors of a number not including the number itself"
  (memoize
   (fn [n]
     (-> n
         divisors
         butlast
         sum))))
