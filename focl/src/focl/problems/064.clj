(ns focl.064)

;; Intro to Reduce
;; Difficulty: Elementary
;; Topics: seqs
;; Reduce takes a 2 argument function and an optional starting value. It then applies the function to the first 2 items in the sequence (or the starting value and the first element of the sequence). In the next iteration the function will be called on the previous return value and the next item from the sequence, thus reducing the entire collection to one value. Don't worry, it's not as complicated as it sounds.
;; (= 15 (reduce __ [1 2 3 4 5]))
;; (=  0 (reduce __ []))
;; (=  6 (reduce __ 1 [2 3]))

(= 15 (reduce (fn [a b] (+ a b)) [1 2 3 4 5])) ;; => true
(= 15 (reduce #(+ %1 %2) [1 2 3 4 5])) ;; => true
(= 15 (reduce + [1 2 3 4 5])) ;; => true
(=  0 (reduce + [])) ;; => true
(=  6 (reduce (fn [a b] (+ a b)) 1 [2 3])) ;; => true
(=  6 (reduce #(+ %1 %2) 1 [2 3])) ;; => true
(=  6 (reduce + 1 [2 3])) ;; => true
