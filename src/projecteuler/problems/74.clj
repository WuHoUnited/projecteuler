(ns projecteuler.problems.74
  (:require [projecteuler.library :as lib]))

;; Digit factorial sum is considerably faster written by hand like
;; this than using list comprehensions
(defn digit-factorial-sum [n]
  (loop [n n
         acc 0]
    (if (zero? n)
      acc
      (recur (quot n 10)
             (+ acc
                (lib/factorial (mod n 10)))))))

(def only-loops {169 3
                 363601 3
                 1454 3
                 871 2
                 45361 2
                 872 2
                 45362 2})

(defmacro case-map [expr mapping]
  (let [cases (mapcat seq (eval mapping))] 
    `(case ~expr
       ~@cases
       nil)))

(defn chain-length [n]
  (if-let [v (case-map n only-loops)]
    v
    (let [next-n (digit-factorial-sum n)]
      (if (== next-n n)
        1
        (inc (chain-length next-n))))))

(defn problem-74
  ([]
   (problem-74 60 1e6))
  ([terms limit]
   (->> (range limit)
        (map chain-length)
        (filter (partial == terms)) 
        count)))

#_(problem-74)
