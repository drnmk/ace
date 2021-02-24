;; #83
;; A Half-Truth
;; Difficulty: Easy
; Topics: Write a function which takes a variable number of booleans. Your function should return true if some of the parameters are true, but not all of the parameters are true. Otherwise your function should return false.
;; (= false (__ false false))
;; (= true (__ true false))
;; (= false (__ true))
;; (= true (__ false true false))
;; (= false (__ true true true))
;; (= true (__ true true true false))

;; contains
(contains? {:a 1} :a) ;; => true
(contains? {:a nil} :a) ;; => true
(contains? {:a 1} 1) ;; => false
;; it's about *indices* or *keys*, not *contents*
(contains? [:a :b :c] :b) ;; => false  
(contains? [:a :b :c] 2) ;; => true   
(contains? "f" 0) ;; => true
(contains? "f" 1) ;; => false
;; Although lists are sequences, they are not keyed sequences.
;; contains? should not be used for lists.
(contains? '(1 2 3) 1) ;; IllegalArgumentException (Clojure >=1.5)
;; It also works on native arrays, HashMaps or HashSets:
;; Can be used to test set membership
(def s #{"a" "b" "c"})
;; The members of a set are the keys of those elements.
(contains? s "a") ;; => true
(contains? s "z") ;; => false
;; When "key" is a number, it is expected to be an integer. 
;; Beyond that limit, lossy truncation may result in unexpected results:
(contains? [1 2 3] 4294967296) ;; => true

;; not=
(not= 1 1) ;; => false
(not= 0 1) ;; => true
(not= 0 0 1) ;; => true
(not= true false) ;; => true
(not= true false false) ;; => true
(not= false false false) ;; => false

;; trial 1
(contains? [1 2 3] 2) ;; => true
(if (= true true) :true :false) ;; => :true
(defn f1 [& bools]
  (let [ks (into #{} (map (fn [x] (if (= x true) :t :f))
                          bools))]
    (and (contains? ks :t)
         (contains? ks :f))))
(= false (f1 false false)) ;; => true
(= true (f1 true false)) ;; => true
(= false (f1 true)) ;; => true
(= true (f1 false true false)) ;; => true
(= false (f1 true true true)) ;; => true
(= true (f1 true true true false)) ;; => true

;; trial 2
;; referred to
;; https://gist.github.com/SegFaultAX/3607101
(defn f2 [& bools]
  (apply not= bools))
(= false (f2 false false)) ;; => true
(= true (f2 true false)) ;; => true
(= false (f2 true)) ;; => true
(= true (f2 false true false)) ;; => true
(= false (f2 true true true)) ;; => true
(= true (f2 true true true false)) ;; => true
