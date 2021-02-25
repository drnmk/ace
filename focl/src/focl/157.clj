;; #157
;; Indexing Sequences
;; Difficulty: Easy
;; Topics: seqs
;; Transform a sequence into a sequence of pairs containing the original elements along with their index.
;; (= (__ [:a :b :c]) [[:a 0] [:b 1] [:c 2]])
;; (= (__ [0 1 3]) '((0 0) (1 1) (3 2)))
;; (= (__ [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]])

;; trial 1
(zipmap [1 2 3] [4 5 6]) ;; => {1 4, 2 5, 3 6}
(range (count [:a :b :c])) ;; => (0 1 2)
(zipmap [:a :b :c] [0 1 2]) ;; => {:a 0, :b 1, :c 2}
(vec {:a 0, :b 1, :c 2}) ;; => [[:a 0] [:b 1] [:c 2]]
(defn f1 [coll]
  (->> coll
       (count)
       (range)
       (zipmap coll)
       (vec)))
(= (f1 [:a :b :c]) [[:a 0] [:b 1] [:c 2]]) ;; => true
(= (f1 [0 1 3]) '((0 0) (1 1) (3 2))) ;; => true
(= (f1 [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]]) ;; => true
