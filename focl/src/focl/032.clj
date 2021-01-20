(ns focl.032)

;; Duplicate a Sequence
;; Difficulty:	Easy
;; Topics:	seqs
;; Write a function which duplicates each element of a sequence.
;; (= (__ [1 2 3]) '(1 1 2 2 3 3))
;; (= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
;; (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))
;; (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))

(defn f [vct]
  (loop [l (into '() vct) r nil]
    (if (empty? l)
      r
      (recur
       (rest l)
       (conj r (first l) (first l))))))

(= (f [1 2 3]) '(1 1 2 2 3 3)) ;; => true
(= (f [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)) ;; => true
(= (f [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])) ;; => true
(= (f [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])) ;; => true
