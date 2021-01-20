(ns focl.034)

;; Difficulty:	Easy
;; Topics:	seqs core-functions
;; Write a function which creates a list of all integers in a given range.
;; Special Restrictions: range
;; (= (__ 1 4) '(1 2 3))
;; (= (__ -2 2) '(-2 -1 0 1))
;; (= (__ 5 8) '(5 6 7))

(defn f [beg end]
  (loop [n beg
         r []]
    (if (>= n end)
      r
      (recur
       (+ n 1)
       (conj r n)))))

(= (f 1 4) '(1 2 3)) ;; => true
(= (f -2 2) '(-2 -1 0 1)) ;; => true
(= (f 5 8) '(5 6 7)) ;; => true
