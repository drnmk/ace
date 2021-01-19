(ns focl.024)

;; Sum It All Up
;; Difficulty: Easy
;; Topics: seqs
;; Write a function which returns the sum of a sequence of numbers.
;; (= (__ [1 2 3]) 6)
;; (= (__ (list 0 -2 5 5)) 8)
;; (= (__ #{4 2 1}) 7)
;; (= (__ '(0 0 -1)) -1)
;; (= (__ '(1 10 3)) 14)

(defn f [coll]
  (loop [c coll s 0]
    (if (empty? c)
      s
      (recur
       (rest c) (+ s (first c))))))

(= (f [1 2 3]) 6) ;; => true
(= (f (list 0 -2 5 5)) 8) ;; => true
(= (f #{4 2 1}) 7) ;; => true
(= (f '(0 0 -1)) -1) ;; => true
(= (f '(1 10 3)) 14) ;; => true
