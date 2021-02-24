;; #41
;; Drop Every Nth Item
;; Difficulty: Easy
;; Topics: seqs
;; Write a function which drops every Nth item from a sequence.
;; (= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
;; (= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
;; (= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])

;; partition-all
(partition-all 4 [1 2 3 4 5 6]) ;; => ((1 2 3 4) (5 6))
(partition-all 3 [0 1 :a "x" 3 [7 8] '(:g 7)]) ;; => ((0 1 :a) ("x" 3 [7 8]) ((:g 7)))
(partition-all 2 4 [0 1 2 3 4 5 6 7 8 9]) ;; => ((0 1) (4 5) (8 9))

;; trial 1
;; reference:
;; https://gist.github.com/SegFaultAX/3607101
(partition-all 2 3 [1 2 3 4 5 6 7 8]) ;; => ((1 2) (4 5) (7 8))
(mapcat identity [[1 2] [4 5] [7 8]]) ;; => (1 2 4 5 7 8)
(defn f1 [coll n]
  (mapcat
   identity
   (partition-all (dec n) n coll)))
(= (f1 [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]);; => true
(= (f1 [:a :b :c :d :e :f] 2) [:a :c :e]) ;; => true
(= (f1 [1 2 3 4 5 6] 4) [1 2 3 5 6]) ;; => true
