;; #49
;; Split a sequence
;; Difficulty: Easy
;; Topics: seqs core-functions
;; Write a function which will split a sequence into two parts.
;; (= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
;; (= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]])
;; (= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])
;; Special Restrictions: split-at

;; drop
(drop 2 [5 6 7 8]) ;; => (7 8)
(drop 3 [5 6 7 8]) ;; => (8)
(drop 0 [2 3 4]) ;; => (2 3 4) 
(drop -1 [4 5 6]) ;; => (4 5 6)

;; range
(range 1 4) ;; => (1 2 3)

;; take
(take 3 [1 2 3 4 5 6]) ;; => (1 2 3)
(take 0 [4 5 6 7]) ;; => ()
(take -1 [3 4 5]) ;; => ()

;; reference:
;; https://gist.github.com/SegFaultAX/3607101
(take 3 [1 2 3 4 5 6]) ;; => (1 2 3)
(drop 3 [1 2 3 4 5 6]) ;; => (4 5 6)
(defn f1 [n coll]
  [(take n coll)
   (drop n coll)])
(= (f1 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]]) ;; => true
(= (f1 1 [:a :b :c :d]) [[:a] [:b :c :d]]) ;; => true
(= (f1 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]]) ;; => true
