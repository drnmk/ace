;; #88
;; Symmetric Difference
;; Difficulty: Easy
;; Topics: set-theory
;; Write a function which returns the symmetric difference of two sets. The symmetric difference is the set of items belonging to one but not both of the two sets.
;; (= (__ #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
;; (= (__ #{:a :b :c} #{}) #{:a :b :c})
;; (= (__ #{} #{4 5 6}) #{4 5 6})
;; (= (__ #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})

;; trial 1
(require '[clojure.set :refer [union difference]])
(defn f1 [a b]
  (union (difference a b) (difference b a)))
(= (f1 #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7}) ;; => true
(= (f1 #{:a :b :c} #{}) #{:a :b :c}) ;; => true
(= (f1 #{} #{4 5 6}) #{4 5 6}) ;; => true
(= (f1 #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]}) ;; => true
