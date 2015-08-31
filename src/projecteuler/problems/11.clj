(ns projecteuler.problems.11
  (:require [projecteuler.library :as lib]))

(defn trim-first-column [matrix]
  (map rest matrix))

(defn transpose [matrix]
  (if (empty? (first matrix))
    []
    (lazy-seq (cons (map first matrix)
                    (transpose (trim-first-column matrix))))))

(defn long-diagonal-top-left [matrix]
  (loop [[[x :as row] :as matrix] matrix
         acc []] 
    (if x
      (recur (map rest (rest matrix))
             (conj acc x ))
      acc)))

(defn left-diagonals [matrix]
  (map long-diagonal-top-left (lib/tails matrix)))

(defn top-diagonals [matrix]
  (if (ffirst matrix)
    (lazy-seq
     (cons
      (long-diagonal-top-left matrix)
      (top-diagonals (trim-first-column matrix))))
    []))

(defn diagonals-top-left->bottom-right [matrix]
  (concat (left-diagonals matrix)
          (rest (top-diagonals matrix))))

(defn rotate-matrix [matrix]
  (->> matrix transpose reverse))

(defn diagonals [matrix]
  (concat (diagonals-top-left->bottom-right matrix)
          (diagonals-top-left->bottom-right (rotate-matrix matrix))))

(defn all-lines [matrix]
  (concat matrix
          (transpose matrix)
          (diagonals matrix)))

(defn problem-11
  ([] (problem-11 "resources/11.txt"))
  ([file-location] 
   (->> file-location
        lib/load-ints-2d
        all-lines
        (mapcat (partial lib/subseqs-of-length 4))
        (map lib/product)
        (apply max))))

#_(problem-11)
