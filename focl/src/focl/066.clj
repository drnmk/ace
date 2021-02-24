;; #66
;; Greatest Common Divisor
;; Difficulty: Easy
;; Topics: Given two integers, write a function which returns the greatest common divisor.
;; (= (__ 2 4) 2)
;; (= (__ 10 5) 5)
;; (= (__ 5 7) 1)
;; (= (__ 1023 858) 33)

;; mod
(mod 10 3);; => 1
;; zero?
(zero? 2) ;; => false
(zero? 0) ;; => true
;; recur
(defn test [n]
  (if (= n 5)
    n
    (recur (inc n))))
(test 0) ;; => 5

;; trial 1
;; reference:
;; https://stackoverflow.com/questions/32386047/greatest-common-divisor-in-clojure
[3 9] ;; => [3 9]
[9 (mod 3 9)] ;; => [9 3]
[3 (mod 9 3)] ;; => [3 0]
[0 3] ;; => [0 3]
[3 (mod 0 3)] ;; => [3 0]
3 ;; => 3 
(defn f1 [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))
(= (f1 2 4) 2) ;; => true
(= (f1 10 5) 5) ;; => true
(= (f1 5 7) 1) ;; => true
(= (f1 1023 858) 33) ;; => true
