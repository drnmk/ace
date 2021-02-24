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

;; int
(int "3")

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

;; merge-with
;; (merge-with f & maps)
(merge-with + {:a 1 :b 2} {:a 9 :c 0}) ;; => {:a 10, :b 2, :c 0}
(merge-with cons {:a 1 :b 2} {:a 9 :c 0})

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

;; transient
(transient [1 2 3]) ;; -> shows message regarding type

;; union 
(require '[clojure.set :refer [union]])
(union #{1 2} #{2 3}) ;; => #{1 3 2}
