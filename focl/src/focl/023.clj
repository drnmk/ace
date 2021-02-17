(ns focl.023a)

;; Reverse a Sequence
;; Difficulty: Easy
;; Topics: seqs core-functions
;; Write a function which reverses a sequence.
;; (= (__ [1 2 3 4 5]) [5 4 3 2 1])
;; (= (__ (sorted-set 5 7 2 7)) '(7 5 2))
;; (= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])
;; Special Restrictions: reverse, rseq

(defn f [seq]
  (loop [o seq r '()]
    (if (empty? o)
      r
      (recur (rest o)
             (conj r (first o))))))

(= (f [1 2 3 4 5]) [5 4 3 2 1]) ;; => true
(= (f (sorted-set 5 7 2 7)) '(7 5 2)) ;; => true
(= (f [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]]) ;; => true
