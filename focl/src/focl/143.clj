;; #143
;; dot product
;; Difficulty: Easy
;; Topics: seqs math
;; Create a function that computes the dot product of two sequences. You may assume that the vectors will have the same length.
;; (= 0 (__ [0 1 0] [1 0 0]))
;; (= 3 (__ [1 1 1] [1 1 1]))
;; (= 32 (__ [1 2 3] [4 5 6]))
;; (= 256 (__ [2 5 6] [100 10 1]))

;; trial 1
(range 3) ;; => (0 1 2)
(map #(get [2 5 6] %) [0 1 2]) ;; => (2 5 6)
(map #(* (get [2 5 6] %) (get [100 10 1] %)) [0 1 2]) ;; => (200 50 6)
(map #(* (get [2 5 6] %) (get [100 10 1] %)) (range 3)) ;; => (200 50 6)
(defn f1 [a b]
  (reduce
   +
   (map #(* (get a %)
            (get b %))
        (range (count a)))))
(= 0 (f1 [0 1 0] [1 0 0])) ;; => true
(= 3 (f1 [1 1 1] [1 1 1])) ;; => true
(= 32 (f1 [1 2 3] [4 5 6])) ;; => true
(= 256 (f1 [2 5 6] [100 10 1])) ;; => true

;; trial 2
(defn f2 [a b]
  (reduce
   +
   (map * a b)))
(= 0 (f2 [0 1 0] [1 0 0])) ;; => true
(= 3 (f2 [1 1 1] [1 1 1])) ;; => true
(= 32 (f2 [1 2 3] [4 5 6])) ;; => true
(= 256 (f2 [2 5 6] [100 10 1])) ;; => true
