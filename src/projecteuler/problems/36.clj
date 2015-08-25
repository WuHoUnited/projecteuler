(ns projecteuler.problems.36
  (:require [projecteuler.problems.library :as lib]))

(defn convert-to-binary [n]
  (if (zero? n)
    [0]
    (loop [n n
           acc ()]
      (if (zero? n)
        acc
        (let [ones-digit (if (odd? n) 1 0)]
          (recur (quot n 2)
                 (conj acc ones-digit)))))))

(defn palindromic-both-bases? [n]
  (and (lib/palindrome? (lib/digits n))
       (lib/palindrome? (convert-to-binary n))))

(defn problem-36
  ([]
   (problem-36 1e6))
  ([limit]
   (->> (range 1 limit)
        (filter palindromic-both-bases?)
        lib/sum)))

#_(problem-36)
