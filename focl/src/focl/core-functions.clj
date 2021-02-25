;;;; clojure core functions ;;;;


;; assoc!
(def t (transient {:x 1})) ;; => #'focl.core/t
(assoc! t :y 2 :z 3) ;; -> shows message regarding type
(count t) ;; => 3
(:y t) ;; => 2
(:z t) ;; => 3

;; cons
(cons 1 [2 3 4]) ;; => (1 2 3 4)
(cons 1 [2]) ;; => (1 2)
(cons 1 '(2)) ;; => (1 2)
(cons :a '(3 4 5)) ;; => (:a 3 4 5)

;; conj
(conj [1 2 3] 4) ;; => [1 2 3 4]
(conj [1 2] 3 4 5) ;; => [1 2 3 4 5]
(conj [1 2 [3 4]]) ;; => [1 2 [3 4]]
(conj '(1 2 3) 4) ;; => (4 1 2 3)
(conj '(1 2) '(3 4)) ;; => ((3 4) 1 2)
(conj '(1 2) 3 4 5) ;; => (5 4 3 1 2)
(conj [[1 2] [3 4]] [5 6]) ;; => [[1 2] [3 4] [5 6]]
(conj {:a 1} {:b 2}) ;; => {:a 1, :b 2}
(conj {:a 1} {:b 2 :c 3}) ;; => {:a 1, :b 2, :c 3}

;; comp
((comp count filter) even? [1 2 3 4 5]) ;; => 2

;; difference
;; (difference s1) (difference s1 s2) (difference s1 s2 & sets)
(require '[clojure.set :refer [difference]])
(difference #{1 2 3}) ;; => #{1 3 2}
(difference #{1 2} #{2 3}) ;; => #{1}
(difference #{1 2 3} #{1} #{1 4} #{3}) ;; => #{2}

;; dissoc!
(def h (transient {:x 1 :y 2 :z 3})) ;; => #'focl.core/h
(dissoc! h :z) ;; -> shows message regarding type
(count h) ;; => 2

;; fn?
(fn? 5) ;; => false
(fn? inc) ;; => true
(fn? (fn [])) ;; => true
(fn? #(5)) ;; => true

;; for
(for [x [1 2 3]
      y [7 8 9]]
  (+ x y)) ;; => (8 9 10 9 10 11 10 11 12)

;; hash-map
(interleave [1 2 3] [4 5 6])

;; group-by
(defn group-by 
  {:added "1.2" :static true}
  [f coll]  
  (persistent!
   (reduce
    (fn [ret x]
      (let [k (f x)]
        (assoc! ret k (conj (get ret k []) x))))
    (transient {}) coll)))
(group-by count ["a" "as" "aa" "qwer"]) ;; => {1 ["a"], 2 ["as" "aa"], 4 ["qwer"]}

;; identity
(identity [1 2 3]) ;; => [1 2 3]
(identity 1) ;; => 1

;; int
(int "3")

;; intersection
(require '[clojure.set :refer [intersection]]) ;; => nil
(intersection #{1}) ;; => #{1} 
(intersection #{1 2} #{2 3}) ;; => #{2}
(intersection #{1 2} #{2 3} #{3 4}) ;; => #{}
(intersection #{1 :a} #{:a 3} #{:a}) ;; => #{:a}

;; into
;; (into) (into to) (into to from) (into to xform from)
(into (sorted-map) [[:a 1] [:c 3] [:b 2]]) ;; => {:a 1, :b 2, :c 3}
(into [1 2 3] '(4 5 6)) ;; => [1 2 3 4 5 6]
(into {:x 4} [{:a 1} {:b 2} {:c 3}]) ;; => {:x 4, :a 1, :b 2, :c 3}

;; juxt
((juxt :a :b) {:a 1 :b 2 :c 3 :d 4}) ;; => [1 2]

;; map
;; (map f) (map f coll) (map f c1 c2) (map f c1 c2 c3) (map f c1 c2 c3 & colls)
(map inc [1 2 3 4 5]) ;; => (2 3 4 5 6)
(map + [1 2 3] [4 5 6]) ;; => (5 7 9)
(map + [1 2 3] (iterate inc 1)) ;; => (2 4 6)

;; merge
(merge {:a 1} {:b 9 :d 4}) ;; => {:a 1, :b 9, :d 4}

;; merge-with
;; (merge-with f & maps)
(merge-with + {:a 1 :b 2} {:a 9 :c 0}) ;; => {:a 10, :b 2, :c 0}
(merge-with cons {:a 1 :b 2} {:a 9 :c 0})

;; mod
(mod 10 7) ;; => 3

;; partial
(def times (partial *)) ;; => #'focl.core/times
(times 1) ;; => 1
(times 1 2 3) ;; => 6
(* 1 2 3) ;; => 6
(def add-hundred (partial + 100)) ;; => #'focl.core/add-hundred
(add-hundred 1) ;; => 101 
(add-hundred 1 2 3) ;; => 106 
(+ 100 1 2 3) ;; => 106

;; partition
(partition 2 [1 2 3 4 5 6]) ;; => ((1 2) (3 4) (5 6))

;; parseint
(Integer/parseInt "123") ;; => 123

;; persistent!
(def t (transient {:a 1})) ;; => #'focl.core/t
(assoc! t :b 2) ;; -> shows message regarding type
(count t) ;; => 2
(persistent! t) ;; can be run only once
(comment (assoc1 t :c 3)) ;; gets error as persistent 

;; reduce
;; (reduce f coll) (reduce f val coll)
(reduce + []) ;; => 0           
(reduce + [1]) ;; => 1          
(reduce + [1 2]) ;; => 3        
(reduce + [1 2 3]) ;; => 6
(reduce + 1 []) ;; => 1        
(reduce + 1 [2 3]) ;; => 6
(reduce - [1 2 3]) ;; => -4
(reduce - 100 [1 2]) ;; => 97

;; split
;; (split s re) (split s re limit)
(require '[clojure.string :refer [split]])
(split "Lisp is great!" #" ") ;; => ["Lisp" "is" "great!"]
(split "Lisp!" #"") ;; => ["L" "i" "s" "p" "!"]

;; threading macro - single arrow
;; inserts the first value as its first argument
(defn transnum* [x]
  (-> x
      (- 3)
      (/ 10))) ;; => #'focl.core/transnum*
;; macroexpand: (/ (- x 3) 10)
(transnum* 5) ;; => 1/5

;; threading macro - double arrows
(defn transnum** [x]
  (->> x
      (- 3)
      (/ 10))) ;; => #'focl.core/transnum**
;; macroexpand: (/ 10 (- 3 x))
(transnum** 5) ;; => -5

;; threading macro - as-arrow
(as-> [:foo :bar] v
  (map name v)
  (first v)
  (str v "!")) ;; => "foo!"

;; transient
(transient [1 2 3]) ;; -> shows message regarding type

;; true?
(true? [true false]) ;; => false
(true? [true true])

;; union 
(require '[clojure.set :refer [union]])
(union #{1 2} #{2 3}) ;; => #{1 3 2}

;; unquote
(def a 3) ;; => #'focl.core/a
'(a a) ;; => (a a)
`(a ~a) ;; => (a ~a)

;; quot
;; quot[ient] of dividing numerator by denominator
(quot 5 2) ;; => 2
(quot 10 3) ;; => 3
