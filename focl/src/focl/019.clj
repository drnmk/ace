(ns focl.019)

;; Last Element
;; Difficulty:	Easy
;; Topics: seqs core-functions
;; Write a function which returns the last element in a sequence.
;; (= (__ [1 2 3 4 5]) 5)
;; (= (__ '(5 4 3)) 3)
;; (= (__ ["b" "c" "d"]) "d")

(defn f [coll]
  (nth coll (- (count coll) 1)))

(= (f [1 2 3 4 5]) 5) ;; => true
(= (f '(5 4 3)) 3) ;; => true
(= (f ["b" "c" "d"]) "d") ;; => true
