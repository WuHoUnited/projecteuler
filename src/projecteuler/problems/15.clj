(ns projecteuler.problems.15)

(def ways
  (memoize
   (fn [x y]
     (if (or (zero? x)
             (zero? y))
       1
       (+ (ways x (dec y))
          (ways (dec x) y))))))

(defn problem-15
  ([]
   (problem-15 20 20))
  ([width height]
   (ways width
         height)))

#_(problem-15)
