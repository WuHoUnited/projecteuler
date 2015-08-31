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

(defn def-all-tests [tests]
  (doseq [[number answer & args] tests]
    (define-single-test number answer args)))

(def-all-tests
  (->> "resources/answers.clj"
       slurp
       read-string))

#_(time (run-tests))
