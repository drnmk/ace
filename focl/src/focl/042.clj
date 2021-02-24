;; Factorial Fun
;; Difficulty:	Easy
;; Topics:	math
;; Write a function which calculates factorials.
;; (= (__ 1) 1)
;; (= (__ 3) 6)
;; (= (__ 5) 120)
;; (= (__ 8) 40320)

;; trial 1
(defn f1 [n]
  (loop [i n
         r 1]
    (if (<= i 1)
      r
      (recur
       (- i 1)
       (* r i)))))
(= (f1 1) 1) ;; => true
(= (f1 3) 6) ;; => true
(= (f1 5) 120) ;; => true
(= (f1 8) 40320) ;; => true

;; trial 2
(take 3 (iterate dec 3)) ;; => (3 2 1)
(reduce * '(1 2 3)) ;; => 6
(reduce * (take 3 (iterate dec 3)));; => 6
(defn f2 [n]
  (reduce *
          (take n
                (iterate dec n))))
(= (f2 1) 1) ;; => true
(= (f2 3) 6) ;; => true
(= (f2 5) 120) ;; => true 
(= (f2 8) 40320) ;; => true 

;; trial 3
(defn f3 [n]
  (->> n
      (iterate dec)
      (take n)
      (reduce *)))
(= (f3 1) 1)
(= (f3 3) 6)
(= (f3 5) 120)  
(= (f3 8) 40320)
