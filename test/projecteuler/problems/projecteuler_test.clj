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
  [7 104743 10001]
  [8 23514624000 13 7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450])

#_(run-tests)
