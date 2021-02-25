;; https://www.4clojure.com/problem/97

;; trial 1
(defn f1 [n]
  (loop [i 1
         r [1]]
    (if (>= i (+ n 0))
      r
      (recur
       (+ i 1)
       (map + (concat [0] r) (concat r [0]))))))
(= (f1 1) [1]) ;; => true
(= (map f1 (range 1 6))
   [[1]
    [1 1]
    [1 2 1]
    [1 3 3 1]
    [1 4 6 4 1]]) ;; => true
(= (f1 11)
   [1 10 45 120 210 252 210 120 45 10 1]) ;; => true
