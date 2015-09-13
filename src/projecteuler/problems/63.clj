(ns projecteuler.problems.63
  (:require [projecteuler.library :as lib]))

(defn powers-of [n]
  (iterate (partial *' n) n))

(defn take-while-index-less-than-or-equal-to-digits [ints]
  (loop [[i & is :as ints] ints
         index 1
         acc []]
    (if (> index (count (lib/digits i)))
      acc
      (recur
       is
       (inc index)
       (conj acc i)))))

(defn problem-63
  "This problem doesn't take any parameters because of how specific it is.
  It is also solved in a strange way by knowing a lot about the problem domain.
  The trick is since we use a base-10 system to observe what happens with the powers of 10:
  [10, 100, 1000] with digits [2 3 4]. Notice that the digits always outpace the power by one.
  If you use a base greater than 10, the number of digits will grow even faster (again
  because in a base-10 system each number of digits needs to be multiplied by 10).
  This means that there cannot be a base that starts at 10 or more.

  The next observation to make is that for the 1-digit base the digits will grow
  slower than the power. Once the digits are greater than the power, the power can never
  catch up because it is being multiplied by a number less than 10, but the digits are being
  multiplied by 10 in a base-10 system."
  []
  (->> (range 1 10)
       (map powers-of)
       (map take-while-index-less-than-or-equal-to-digits)
       (map count)
       lib/sum))

#_(problem-63)
