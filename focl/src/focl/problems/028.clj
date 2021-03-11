;; #28
;; Flatten a Sequence
;; Difficulty:	Easy
;; Topics: seqs core-functions
;; Write a function which flattens a sequence.
;; (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
;; (= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
;; (= (__ '((((:a))))) '(:a))
;; Special Restrictions: flatten

;; identity
(identity 1) ;; => 1
(identity [1 2 3]) ;; => [1 2 3]
(identity '(1 2 3)) ;; => (1 2 3)
;; tree-seq
(tree-seq seq? identity '((1 2 (3)) (4))) ;; => (((1 2 (3)) (4)) (1 2 (3)) 1 2 (3) 3 (4) 4) 
(tree-seq seq? identity '(1 2 (3 (4 5 6)))) ;; => ((1 2 (3 (4 5 6))) 1 2 (3 (4 5 6)) 3 (4 5 6) 4 5 6)
(tree-seq seq? identity [1 2 [3 4 [5 6 7]]]) ;; => ([1 2 [3 4 [5 6 7]]])
(tree-seq seq? rest '((1 2 (3)) (4))) ;; => (((1 2 (3)) (4)) (4))
(tree-seq nil? identity '((1 2 (3)) (4))) ;; => (((1 2 (3)) (4)))
(tree-seq coll? identity '((1 2 (3)) (4))) ;; => (((1 2 (3)) (4)) (1 2 (3)) 1 2 (3) 3 (4) 4)
(tree-seq empty? identity '((1 2 (3)) (4))) ;; => (((1 2 (3)) (4)))
;; complement
((complement nil?) 123) ;; => true

;; trial 1
;; referred to
;; https://github.com/qiuxiafei/4clojure/blob/master/answers/28.Flatten%20a%20Sequence
(defn f1 [sq]
  (filter (fn [x] ((complement sequential?) x)) 
          (tree-seq sequential? identity sq)))
(= (f1 '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)) ;; => true
(= (f1 ["a" ["b"] "c"]) '("a" "b" "c")) ;; => true
(= (f1 '((((:a))))) '(:a)) ;; => true

;; trial 2
(defn f2 [sq]
  (filter (complement sequential?) 
          (tree-seq sequential? identity sq)))
(= (f2 '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)) ;; => true
(= (f2 ["a" ["b"] "c"]) '("a" "b" "c")) ;; => true
(= (f2 '((((:a))))) '(:a)) ;; => true
