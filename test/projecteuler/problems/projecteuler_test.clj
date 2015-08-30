(ns projecteuler.problems.projecteuler-test
  (:require [clojure.test :refer :all]))

(defn test-defining-list [number answer args] 
  (let [fn-name (str "problem-" number)
        test-name (symbol (str fn-name "-test"))
        namespace-str (str "projecteuler.problems." number)
        namespace-symbol (symbol namespace-str) 
        fn-symbol (symbol namespace-str fn-name)
        test-description (str "Project Euler " number)]
    `(deftest ~test-name
       (testing ~test-description
         (require '~namespace-symbol :reload-all)
         (is (= ~answer 
                (apply (resolve '~fn-symbol)
                       ~(vec args))))))))

(defn define-single-test [number answer args]
  (eval (test-defining-list number answer args)))

(defn def-all-tests [& tests]
  (doseq [[number answer & args] tests]
    (define-single-test number answer args)))

(def-all-tests
  [1 233168 [3 5] 1000]
  [2 4613732 4e6]
  [3 6857 600851475143]
  [4 906609 3]
  [5 232792560 20]
  [6 25164150 100]
  [7 104743 10001]
  [8 23514624000 13 "resources/8.txt"]
  [9 31875000 1000]
  [10 142913828922 2e6]
  [11 70600674 "resources/11.txt"]
  #_[12 76576500 500]
  [13 "5537376230" "resources/13.txt" 10]
  [14 837799 1e6]
  [15 137846528820 20 20]
  [16 1366 2 1000]
  [18 1074 "resources/18.txt"]
  [20 648 100]
  #_[21 31626 1e5]
  [22 871198282 "resources/22.txt"]
  [23 4179871 28123]
  [24 "2783915460" (vec (range 10)) 1e6]
  [25 4782 1000]
  [26 983 1000]
  [27 -59231 1000 1000]
  [28 669171001 1001]
  [29 9183 100 100]
  [30 443839 5]
  [31 73682 #{1 2 5 10 20 50 100 200} 200]
  [34 40730]
  [35 55 1e6]
  [36 872187 1e6]
  [40 210 7]
  [42 162 "resources/42.txt"]
  [50 997651 1e6]
  [67 7273 "resources/67.txt"])

#_(time (run-tests))
