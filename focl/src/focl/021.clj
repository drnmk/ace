(ns focl.021)

;; Nth Element
;; Difficulty: Easy
;; Topics: seqs core-functions
;; Write a function which returns the Nth element from a sequence.
;; Special Restrictions: nth
;; (= (__ '(4 5 6 7) 2) 6)
;; (= (__ [:a :b :c] 0) :a)
;; (= (__ [1 2 3 4] 1) 2)
;; (= (__ '([1 2] [3 4] [5 6]) 2) [5 6])

(defn f [coll index]
  (loop [c coll i 0]
    (if (>= i index)
      (first c)
      (recur (rest c) (+ i 1)))))

(= (f '(4 5 6 7) 2) 6) ;; => true
(= (f [:a :b :c] 0) :a) ;; => true
(= (f [1 2 3 4] 1) 2) ;; => true
(= (f '([1 2] [3 4] [5 6]) 2) [5 6]) ;; => true
