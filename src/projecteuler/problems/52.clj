(ns projecteuler.problems.52
  (:require [projecteuler.library :as lib]))

(defn get-products [base num-products] 
  (->> (iterate (partial + base) base)
       (take num-products)))

(defn products-same-digits? [n num-products]
  (->> (get-products n num-products)
       (map lib/digits)
       (map frequencies)
       (apply =)))

(defn problem-52 [n]
  (->> (iterate inc 1)
       (filter #(products-same-digits? % n))
       first))

#_(problem-52 6)
