(ns focl.005)

;; Lists: conj
;; Difficulty:	Elementary
;; Topics:	
;; When operating on a list, the conj function will return a new list with one or more items "added" to the front.
;; Note that there are two test cases, but you are expected to supply only one answer, which will cause all the tests to pass.
;; (= __ (conj '(2 3 4) 1))
;; (= __ (conj '(3 4) 2 1))

(= '(1 2 3 4) (conj '(2 3 4) 1)) ;; => true
(= (list 1 2 3 4) (conj '(3 4) 2 1)) ;; => true
