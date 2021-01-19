(ns focl.052)

;; Intro to Destructuring
;; Difficulty: Elementary
;; Topics: destructuring
;; Let bindings and function parameter lists support destructuring.
;; (= [2 4] (let [[a b c d e] [0 1 2 3 4]] __))

(= [2 4] (let [[a b c d e] [0 1 2 3 4]] [c e])) ;; => true
