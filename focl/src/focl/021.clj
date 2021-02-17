(ns focl.021a)

;; Nth Element
;; Difficulty: Easy
;; Topics: seqs core-functions
;; Write a function which returns the Nth element from a sequence.
;; Special Restrictions: nth
;; (= (__ '(4 5 6 7) 2) 6)
;; (= (__ [:a :b :c] 0) :a)
;; (= (__ [1 2 3 4] 1) 2)
;; (= (__ '([1 2] [3 4] [5 6]) 2) [5 6])

;; trial 1
(defn f1 [coll index]
  (loop [c coll i 0]
    (if (>= i index)
      (first c)
      (recur (rest c) (+ i 1)))))

(= (f1 '(4 5 6 7) 2) 6) ;; => true
(= (f1 [:a :b :c] 0) :a) ;; => true
(= (f1 [1 2 3 4] 1) 2) ;; => true
(= (f1 '([1 2] [3 4] [5 6]) 2) [5 6]) ;; => true

;; trial 2
(defn f2 [coll index]
  (get
   (into
    {} (map-indexed hash-map coll))
   index))

(= (f2 '(4 5 6 7) 2) 6) ;; => true
(= (f2 [:a :b :c] 0) :a) ;; => true
(= (f2 [1 2 3 4] 1) 2) ;; => true
(= (f2 '([1 2] [3 4] [5 6]) 2) [5 6]) ;; => true
