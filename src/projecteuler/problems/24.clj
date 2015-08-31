(ns projecteuler.problems.24
  (:require [projecteuler.library :as lib]))

(defn remove-index [index coll] 
  (let [[beginning ending] (split-at index coll)]
    (concat beginning (rest ending))))

(defn permutation [items permutation-index]
  (loop [items items
         permutation-index permutation-index
         acc []]
    (let [size (count items)]
      (if (zero? size)
        acc
        (let [items-per-first-item (lib/factorial (dec size))
              first-item-index (quot permutation-index items-per-first-item)
              remaining-permutation (- permutation-index
                                       (* items-per-first-item
                                          first-item-index))
              first-item (nth items first-item-index)
              remaining-items (remove-index first-item-index items)]
          (recur remaining-items
                 remaining-permutation
                 (conj acc first-item)))))))

(defn problem-24
  ([]
   (problem-24 (range 10) 1e6))
  ([items number]
   (->> (permutation items (dec number))
        (apply str))))

#_(problem-24)
