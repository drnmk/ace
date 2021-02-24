;; #33
;; Replicate a Sequence
;; Difficulty: Easy
;; Topics: seqs
;; Write a function which replicates each element of a sequence a variable number of times.
;; (= (__ [1 2 3] 2) '(1 1 2 2 3 3))
;; (= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b))
;; (= (__ [4 5 6] 1) '(4 5 6))
;; (= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
;; (= (__ [44 33] 2) [44 44 33 33])

;; learn built-in functions
;; repeat 
;; repeat alone should not 
(type (repeat "x")) ;; => clojure.lang.Repeat
(take 5 (repeat "x")) ;; => ("x" "x" "x" "x" "x")
;; concat 
(concat [1 2] [3 4 5]) ;; => (1 2 3 4 5) 
(concat [1 2] '(3 4 5));; => (1 2 3 4 5)
(concat '(1 2) '(3 4 5)) ;; => (1 2 3 4 5) 
(concat [1 2] #{3 4 5}) ;; => (1 2 4 3 5) 
(concat #{1 2} #{3 4 5}) ;; => (1 2 4 3 5) 
(concat {:a 1} [2 3 4]) ;; => ([:a 1] 2 3 4) 
(concat {:a 1} {:b 2}) ;; => ([:a 1] [:b 2])
(concat [1 2] [3 4] [5 6]);; => (1 2 3 4 5 6) 
;; apply
(str 123 456) ;; => "123456" 
(str [123 456]) ;; => "[123 456]" 
(apply str [123 456]) ;; => "123456" 
(max 1 2 3) ;; => 3 
(max [1 2 3]) ;; => [1 2 3] 
(apply max [1 2 3]) ;; => 3
(apply max '(1 2 3)) ;; => 3
(apply max #{1 2 3}) ;; => 3
;; mapcat
(defn tf [n]  [(- n 1) n (+ n 1)]) ;; => #'focl.core/f1
(tf 1) ;; => [0 1 2] 
(map tf [1 2 3]);; => ([0 1 2] [1 2 3] [2 3 4])
(apply concat (map tf [1 2 3])) ;; => (0 1 2 1 2 3 2 3 4) 

;; trial 01
;; referred to
;; https://gist.github.com/djKianoosh/1431997/195c36de234f383a4e0679f022c0ff83a057f008
(defn f1 [sq n]
  (apply concat
         (map (fn [x] (repeat n x))
              sq)))

(= (f1 [1 2 3] 2) '(1 1 2 2 3 3)) ;; => true 
(= (f1 [:a :b] 4) '(:a :a :a :a :b :b :b :b)) ;; => true 
(= (f1 [4 5 6] 1) '(4 5 6)) ;; => true 
(= (f1 [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])) ;; => true 
(= (f1 [44 33] 2) [44 44 33 33]) ;; => true 
