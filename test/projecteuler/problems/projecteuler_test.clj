(ns projecteuler.problems.projecteuler-test
  (:require [clojure.test :refer :all]
            [clojure.pprint :as pp]))

#_(deftest project-euler-tests
    (testing "Project Euler"
      (are [spec]
          (let [[problem-number answer & args] spec
                namespace (str "projecteuler.problems." problem-number)]
            (require (symbol namespace))
            answer
            (apply (resolve (symbol namespace (str "problem-" problem-number))) args))
        [1 233168 [3 5] 1000]
        [2 4613732 4e6])))

(defn test-defining-list [number answer args] 
  (let [fn-name (str "problem-" number)
        test-name (symbol (str fn-name "-test"))
        namespace-str (str "projecteuler.problems." number)
        namespace-symbol (symbol namespace-str) 
        fn-symbol (symbol namespace-str fn-name)
        test-description (str "Project Euler " number)]
    `(deftest ~test-name
       (testing ~test-description
         (require '~namespace-symbol)
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
  [7 104743 10001])

(run-tests)
