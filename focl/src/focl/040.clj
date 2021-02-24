;; #40
;; Interpose a Seq
;; Difficulty:	Easy
;; Topics: seqs core-functions
;; Write a function which separates the items of a sequence by an arbitrary value.
;; (= (__ 0 [1 2 3]) [1 0 2 0 3])
;; (= (apply str (__ ", " ["one" "two" "three"])) "one, two, three")
;; (= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])
;; Special Restrictions: interpose

;; interpose
(interpose ", " ["me" "you" "us"]) ;; => ("me" ", " "you" ", " "us") 
(interpose 0 [1 2 3]) ;; => (1 0 2 0 3)

;; interleave
(interleave [1 2 3] [4 5 6]) ;; => (1 4 2 5 3 6)
(interleave '(1 2 3) [7 8 9]) ;; => (1 7 2 8 3 9)
(interleave [:a :b] [1 2 3]) ;; => (:a 1 :b 2)

;; concat
(concat [1 2] [3 4 5]) ;; => (1 2 3 4 5)
(concat [1 2] '(:a :b :c) #{"x" "y"});; => (1 2 :a :b :c "x" "y")

;; mapcat
(map (fn [x] (+ x 1)) [1 2 3 4]) ;; => (2 3 4 5)
(reverse [[3 2 1 0] [6 5 4] [9 8 7]])
(mapcat reverse [[3 2 1 0] [6 5 4] [9 8 7]])

;; iterate
(take 5 (iterate identity 0)) ;; => (0 0 0 0 0)
(take 3 (iterate inc 1)) ;; => (1 2 3)

;; repeat
(repeat 5 :a) ;; => (:a :a :a :a :a)

;; butlast
(butlast [1 2 3 4]) ;; => (1 2 3)
(butlast '(:a "x" 123)) ;; => (:a "x")

;; trial 1
(defn f1 [piece coll]
  (butlast 
   (interleave
    coll
    (iterate identity piece))))

(= (f1 0 [1 2 3]) [1 0 2 0 3]) ;; => true
(= (apply str (f1 ", " ["one" "two" "three"])) "one, two, three") ;; => true
(= (f1 :z [:a :b :c :d]) [:a :z :b :z :c :z :d]) ;; => true
