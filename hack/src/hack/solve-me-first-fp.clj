;; https://www.hackerrank.com/challenges/fp-solve-me-first/problem

;; 1
(prn (+ (Integer/parseInt (read-line))
        (Integer/parseInt (read-line))))

;; 2
(prn (apply + (map #(Integer/parseInt %) [(read-line) (read-line)])))

;; 3
(->> [(read-line) (read-line)]
     (map #(Integer/parseInt %))
     (apply +)
     prn)
