(ns focl.020)

;; Penultimate Element
;; Difficulty: Easy
;; Topics: seqs
;; Write a function which returns the second to last element from a sequence.
	
(defn f [coll]
  (let [index-second-to-last (- (count coll) 2)]
    (nth coll index-second-to-last)))

(= (f (list 1 2 3 4 5)) 4) ;; => true
(= (f ["a" "b" "c"]) "b") ;; => true
(= (f [[1 2] [3 4]]) [1 2]) ;; => true
