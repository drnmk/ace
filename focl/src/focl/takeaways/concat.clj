;; concat
(concat [1 2] [3 4 5])
;; => (1 2 3 4 5)
(concat [1 2] '(:a :b :c) #{"x" "y"})
;; => (1 2 :a :b :c "x" "y")
