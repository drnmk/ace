(ns focl.042)

;; Factorial Fun
;; Difficulty:	Easy
;; Topics:	math
;; Write a function which calculates factorials.
;; (= (__ 1) 1)
;; (= (__ 3) 6)
;; (= (__ 5) 120)
;; (= (__ 8) 40320)

(defn f [n]
  (loop [i n
         r 1]
    (if (<= i 1)
      r
      (recur
       (- i 1)
       (* r i)))))

(= (f 1) 1) ;; => true
(= (f 3) 6) ;; => true
(= (f 5) 120) ;; => true
(= (f 8) 40320) ;; => true
