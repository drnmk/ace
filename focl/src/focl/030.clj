(ns focl.030)

;; Compress a Sequence
;; Difficulty:	Easy
;; Topics:	seqs
;; Write a function which removes consecutive duplicates from a sequence.
;; (= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
;; (= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
;; (= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

(defn f [vct]
  (loop [r []
         l vct]  
    (if (empty? l)
      r
      (recur
       (if (= (last r) (first l))
         r
         (conj r (first l)))
       (rest l)))))

(= (apply str (f "Leeeeeerrroyyy")) "Leroy") ;; => true
(= (f [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)) ;; => true
(= (f [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])) ;; => true
