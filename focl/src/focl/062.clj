;; #62
;; Re-implement Iterate
;; Difficulty: Easy
;; Topics: seqs core-functions
;; Given a side-effect free function f and an initial value x write a function which returns an infinite lazy sequence of x, (f x), (f (f x)), (f (f (f x))), etc.
;; (= (take 5 (__ #(* 2 %) 1)) [1 2 4 8 16])
;; (= (take 100 (__ inc 0)) (take 100 (range)))
;; (= (take 9 (__ #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))
;; Special Restrictions: iterate

;; iterate
(take 4 (iterate inc 3)) ;; => (3 4 5 6)
;; cons
(cons 1 [2 3 4]) ;; => (1 2 3 4)
(cons "a" '(1 2 3)) ;; => ("a" 1 2 3)
;; lazy-seq
(defn positive-nums
  ([] (positive-nums 1))
  ([n] (lazy-seq (cons n (positive-nums (inc n))))))
(take 5 (positive-nums)) ;; => (1 2 3 4 5)
;; range
(take 5 (range)) ;; => (0 1 2 3 4)

;; trial 1
(defn f1 [f n]
  (lazy-seq (cons n (f1 f (f n)))))
(= (take 5 (f1 #(* 2 %) 1)) [1 2 4 8 16]) ;; => true
(= (take 100 (f1 inc 0)) (take 100 (range))) ;; => true
(= (take 9 (f1 #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3]))) ;; => true
