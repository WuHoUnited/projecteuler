(ns projecteuler.problems.97
  (:require [projecteuler.library :as lib]))

(defn format-answer [digits n]
  (format (str "%0" digits "d") n))

(defn calculate-97
  ([multiplier power num-digits]
   (let [digits-modulus (lib/pow 10 num-digits)
         get-last-digits (fn [n] (mod n digits-modulus))]
     (loop [power power
            acc 1]
       (if (zero? power)
         (get-last-digits (inc (* multiplier acc)))
         (recur (dec power)
                (get-last-digits (* acc 2))))))))

(defn problem-97
  ([]
   (problem-97 28433 7830457 10))
  ([multiplier power num-digits]
   (->> (calculate-97 multiplier power num-digits)
        (format-answer num-digits))))

#_(problem-97)
