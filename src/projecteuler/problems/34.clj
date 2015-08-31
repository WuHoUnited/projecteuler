(ns projecteuler.problems.34
  (:require [projecteuler.library :as lib]))

(defn calculate-limit []
  (let [nine-factorial (lib/factorial 9)
        all-nines (fn [digits]
                    (* nine-factorial digits))]
    (->> (iterate inc 1)
         (take-while (fn [digits]
                       (<= (lib/pow 10 digits)
                           (all-nines digits))))
         last
         inc
         all-nines)))

(defn digits-factorial [n]
  (->> n
       lib/digits
       (map lib/factorial)
       lib/sum))

(defn is-digit-factorial-sum? [n]
  (== n (digits-factorial n)))

(defn problem-34 []
  (->> (range 3 (inc (calculate-limit)))
       (filter is-digit-factorial-sum?)
       lib/sum))

#_(problem-34)
