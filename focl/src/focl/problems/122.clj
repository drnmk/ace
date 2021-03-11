;; #122
;; Read a binary number
;; Difficulty: Easy
;; Topics: Convert a binary number, provided in the form of a string, to its numerical value.

;; trial 1
;; ref: https://gist.github.com/SegFaultAX/3607101
(Integer/parseInt "1011" 2) ;; => 11
(Integer/parseInt "44" 5) ;; => 24
(Integer/parseInt "44") ;; => 44
(defn f1 [s] (Integer/parseInt s 2))
(= 0     (f1 "0")) ;; => true
(= 7     (f1 "111")) ;; => true
(= 8     (f1 "1000")) ;; => true
(= 9     (f1 "1001")) ;; => true
(= 255   (f1 "11111111")) ;; => true
(= 1365  (f1 "10101010101")) ;; => true
(= 65535 (f1 "1111111111111111")) ;; => true
