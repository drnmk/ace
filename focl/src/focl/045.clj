;; #45
;; Intro to Iterate
;; Difficulty:	Easy
;; Topics: seqs
;; The iterate function can be used to produce an infinite lazy sequence.
;; (= __ (take 5 (iterate #(+ 3 %) 1)))

;; trial 1
(= '(1 4 7 10 13) (take 5 (iterate #(+ 3 %) 1)));; => true

