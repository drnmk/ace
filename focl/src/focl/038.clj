(ns focl.038)

;; Maximum value
;; Difficulty: Easy
;; Topics: core-functions
;; Write a function which takes a variable number of parameters and returns the maximum value.
;; (= (__ 1 8 3 4) 8)
;; (= (__ 30 20) 30)
;; (= (__ 45 67 11) 67)
;; Special Restrictions: max, max-key

(defn f [& nums]
  (loop [max 0 coll nums]
    (if (empty? coll)
      max
      (recur (if (> (first coll) max) (first coll) max)
             (rest coll)))))

(= (f 1 8 3 4) 8) ;; => true
(= (f 30 20) 30) ;; => true
(= (f 45 67 11) 67) ;; => true
