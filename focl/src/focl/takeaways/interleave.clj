(interleave [1 2 3] [4 5 6]) ;; => (1 4 2 5 3 6)
(interleave '(1 2 3) [7 8 9]) ;; => (1 7 2 8 3 9)
(interleave [:a :b] [1 2 3]) ;; => (:a 1 :b 2)
