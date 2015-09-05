(ns projecteuler.problems.47
  (:require [projecteuler.library :as lib]))

(defn unique-factors [n]
  (-> n lib/factors distinct))

(defn subseqs [length coll]
  (let [start (take length coll)]
    (if (== (count start) length)
      (lazy-seq
       (cons start
             (subseqs length (rest coll)))))))

(defn subseq-meets-criteria? [num-factors subseq]
  (let [seq-factors (->> subseq
                         (map first))]
    (and (every? (fn [factors]
                   (== num-factors
                       (count factors)))
                 seq-factors)
         (apply distinct? seq-factors))))

(defn problem-47
  ([]
   (problem-47 4 4))
  ([consecutive factors]
   (->> (iterate inc 2)
        (map (juxt unique-factors identity))
        (subseqs consecutive)
        (filter (partial subseq-meets-criteria? factors))
        first
        first
        second)))

#_(problem-47)
