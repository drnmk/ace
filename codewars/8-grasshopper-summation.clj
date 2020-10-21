(comment "
Write a program that finds the summation of every number from 1 to num. The number will always be a positive integer greater than 0.
For example:
summation(2) -> 3
1 + 2
summation(8) -> 36
1 + 2 + 3 + 4 + 5 + 6 + 7 + 8")

;; solution 1
(defn summation-1 [n]
  (letfn [(up [i n]
            (if (> i n)
              0
              (+ i (up (+ i 1) n))))]
    (up 0 n)))

(summation-1 8) ;; 36
;; 1941ms

;; solution 2
(defn summation-2 [n]
  (letfn [(down [i n]
            (if (< i 1)
              0
              (+ i (down (- i 1) n))))]
    (down n n)))

(summation-2 8) ;; 36

;; solution 3
(defn summation-3 [n]
  (loop [total 0
         i 0]
    (if (> i n)
      total
      (recur (+ total i) (+ i 1)))))

(summation-3 8) ;; 36

;; solution 4
(defn summation-4 [n]
  (apply + (range (+ n 1))))

(summation-4 8) ;; 36

;; solution 5
(defn summation-5 [n]
  (/ (* n
        (+ n 1))
     2))

(summation-5 8) ;; 36