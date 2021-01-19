(ns focl.025)

;; Find the odd numbers
;; Difficulty: Easy
;; Topics: seqs
;; Write a function which returns only the odd numbers from a sequence.
;; (= (__ #{1 2 3 4 5}) '(1 3 5))
;; (= (__ [4 2 1 6]) '(1))
;; (= (__ [2 2 4 6]) '())
;; (= (__ [1 1 1 3]) '(1 1 1 3))

(defn f [seq]
  (filter (fn [x] (= (rem x 2) 1))
          seq))

(= (f #{1 2 3 4 5}) '(1 3 5)) ;; => true
(= (f [4 2 1 6]) '(1)) ;; => true
(= (f [2 2 4 6]) '()) ;; => true
(= (f [1 1 1 3]) '(1 1 1 3)) ;; => true
