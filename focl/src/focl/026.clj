;; Fibonacci Sequence
;; Difficulty:	Easy
;; Topics: Fibonacci seqs
;; Write a function which returns the first X fibonacci numbers.
;; (= (__ 3) '(1 1 2))
;; (= (__ 6) '(1 1 2 3 5 8))
;; (= (__ 8) '(1 1 2 3 5 8 13 21))

;; iterate
(take 7 (iterate inc 5))  ;; => (5 6 7 8 9 10 11)
(take 7 (iterate dec 5))  ;; => (5 4 3 2 1 0 -1)
(take 4 (iterate (fn [x] (* 7 x)) 5)) ;; => (5 35 245 1715)

;; trial 1
;; referred to
;; https://github.com/qiuxiafei/4clojure/blob/master/answers/26.Fibonacci%20Sequence
(defn f1 [n]
  (take n
        (map last 
             (iterate
              (fn [[x y]] [y (+ x y)])
              [0 1]))))
(= (f1 3) '(1 1 2));; => true
(= (f1 6) '(1 1 2 3 5 8));; => true
(= (f1 8) '(1 1 2 3 5 8 13 21));; => true
