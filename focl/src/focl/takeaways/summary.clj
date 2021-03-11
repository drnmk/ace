;;;; clojure core functions ;;;;

;; apply
(def names ["jack" "ma"])
(str names) ;; => "[\"jack\" \"ma\"]"
(apply str names) ;; => "jackma"
(max 1 2 3) ;; => 3
(max [1 2 3]) ;; => [1 2 3]
(apply max [1 2 3]) ;; => 3
(apply map inc [[1 2 3]]) ;; => (2 3 4)
(str 123 456) ;; => "123456" 
(str [123 456]) ;; => "[123 456]" 
(apply str [123 456]) ;; => "123456" 
(max 1 2 3) ;; => 3 
(max [1 2 3]) ;; => [1 2 3] 
(apply max [1 2 3]) ;; => 3
(apply max '(1 2 3)) ;; => 3
(apply max #{1 2 3}) ;; => 3

;; assoc
(assoc {} :key1 "v" :key2 "another") ;; => {:key1 "v", :key2 "another"}
(assoc nil :key1 4) ;; => {:key1 4}
(assoc [1 2 3] 3 10) ;; => [1 2 3 10]

;; assoc-in
(def users [{:name "James" :age 26}  {:name "John" :age 43}])
(assoc-in users [1 :age] 44) ;; => [{:name "James", :age 26} {:name "John", :age 44}]
(assoc-in users [0 :name] "Jackie") ;; => [{:name "Jackie", :age 26} {:name "John", :age 43}]
(assoc-in users [2] {:name "Jack" :age 19})
;; => [{:name "James", :age 26}
;;     {:name "John", :age 43}
;;     {:name "Jack", :age 19}]  

;; assoc!
(def t (transient {:x 1})) ;; => #'focl.core/t
(assoc! t :y 2 :z 3) ;; -> shows message regarding type
(count t) ;; => 3
(:y t) ;; => 2
(:z t) ;; => 3

;; atom
(def age (atom 10)) ;; => #'focl.core/age
age ;; => #<Atom@4847bf9b: 10>
(deref age) ;; => 10
@age ;; => 10

;; capitalize
(clojure.string/capitalize "abc") ;; => "Abc"

;; concat
(concat [1 2] [3 4]) ;; => (1 2 3 4)
(apply concat [[1 2] [3 4]]) ;; => (1 2 3 4)
(concat [1 2] [3 4 5]) ;; => (1 2 3 4 5) 
(concat [1 2] '(3 4 5));; => (1 2 3 4 5)
(concat '(1 2) '(3 4 5)) ;; => (1 2 3 4 5) 
(concat [1 2] #{3 4 5}) ;; => (1 2 4 3 5) 
(concat #{1 2} #{3 4 5}) ;; => (1 2 4 3 5) 
(concat {:a 1} [2 3 4]) ;; => ([:a 1] 2 3 4) 
(concat {:a 1} {:b 2}) ;; => ([:a 1] [:b 2])
(concat [1 2] [3 4] [5 6]);; => (1 2 3 4 5 6) 

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
((comp inc dec inc *) 1 2 3) ;; => 7

;; complement
((complement even?) 1) ;; => true
(#(not (even? %)) 1) ;; => true

;; contains?
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
;; java method of contains
(.contains [:a :b :c] :c) ;; => true
(contains? (set [:a :b :c]) :b) ;; => true
(contains? #{:a :b} :a) ;; => true

;; delay
;; Takes a body of expressions and yields a Delay object that will
;; invoke the body only the first time it is forced (with force or deref/@), and
;; will cache the result and return it on all subsequent force calls. 
(def my-delay (delay (println "did it") 100))
(realized? my-delay) ;; => false
my-delay ;; => #<Delay@3a106f3a: :not-delivered>
@my-delay ;; => 100
(realized? my-delay) ;; => true

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

;; doseq
;; mostly for side effects
(doseq [x [-1 0]
        y [1 2]] 
  (prn (* x y))) ;; -1 -2 0 0

;; dotimes
(dotimes [x 3]
  (prn x)) ;; print 0 1 2

;; drop
(drop 2 [5 6 7 8]) ;; => (7 8)
(drop 3 [5 6 7 8]) ;; => (8)
(drop 0 [2 3 4]) ;; => (2 3 4) 
(drop -1 [4 5 6]) ;; => (4 5 6)

;; drop-while
;; drop from the beginning consecutively
(drop-while even? [2 4 5 7]) ;; => (5 7)
(drop-while even? [1 4 5 7]) ;; => (1 4 5 7)
(filter #(not (even? %)) [1 4 5 7]) ;; => (1 5 7)

;; empty?
(empty? []) ;; => true
(empty? '()) ;; => true
(empty? #{}) ;; => true

;; equal
(= 3 3) ;; => true

;; fn?
(fn? 5) ;; => false
(fn? inc) ;; => true
(fn? (fn [])) ;; => true
(fn? #(5)) ;; => true

;; for
(for [x [1 2 3]
      y [7 8 9]]
  (+ x y)) ;; => (8 9 10 9 10 11 10 11 12)

;; frequencies
(frequencies [:a :a :b :b :b]) ;; => {:a 2, :b 3}
(distinct [:a :a :b :b :b]) ;; => (:a :b)
(group-by identity [1 1 2 2 2]) ;; => {1 [1 1], 2 [2 2 2]}
(count [1 2 3]) ;; => 3
(map count [[1 2 3] [4 5]])

(defn frequencies-2 [coll]
  (let [gcoll (group-by identity coll)]
    (zipmap
     (keys gcoll)
     (map count (vals gcoll)))))

(frequencies-2 [1 1 2 2 2]) ;; => {1 2, 2 3}
(group-by identity [1 1 2 2 2]) ;; => {1 [1 1], 2 [2 2 2]}
(keys {1 [1 1], 2 [2 2 2]}) ;; => (1 2)
(vals {1 [1 1], 2 [2 2 2]}) ;; => ([1 1] [2 2 2])
(map count '([1 1] [2 2 2])) ;; => (2 3)
(zipmap '(1 2) '(2 3)) ;; => {1 2, 2 3}
(frequencies-2 [1 1 2 2 2])
(count (first '([1 1] [2 2 2])))
(defn frequencies-3 [coll]
  (reduce (fn [m x] (assoc m x (inc (get m x))))
          (zipmap (distinct coll) (repeat 0))
          coll))
(frequencies-3 [:a :a :b :b :b])
(frequencies-3 [])
(defn frequencies-4 [coll]
  (reduce
   (fn [m x] (assoc m x (inc (get m x 0))))
   {}
   coll))
(frequencies-4 [:a :a :b :b :b])
(frequencies-4 [])
(defn frequencies-5 [coll]
  (reduce
   (fn [m x] (update m x (fn [n] (if (nil? n) 1 (+ n 1)))))
   {}
   coll))
(frequencies-5 [:a :a :b :b :b])
(frequencies-5 [])
(defn frequencies-6 [coll]
  (reduce
   (fn [m x] (update m x #(inc (or % 0))))
   {}
   coll))
(frequencies-6 [:a :a :b :b :b])
(frequencies-6 [])
(or 5 0) ;; => 5
(or nil 3) ;; => 3
(defn frequencies-7 [coll]
  (reduce
   (fn [m x] (update m x (fnil inc 0)))
   {}
   coll))
(frequencies-7 [:a :a :b :b :b])
(frequencies-7 [])

((fnil inc 0) nil) ;; => 1
((fnil inc 0) 3) ;; => 4



;; future
;; Takes a body of expressions and yields a future object that will
;; invoke the body in another thread, and will cache the result and
;; return it on all subsequent calls to deref/@. If the computation has
;; not yet finished, calls to deref/@ will block, unless the variant of
;; deref with timeout is used. See also - realized?.
(def f (future (Thread/sleep 10000) (println "done") 100))
(realized? f) ;; => false
@f ;; => done 100
@f ;; => 100
(realized? f) ;; => true

;; get
(get {:a 1 :b 2} :a) ;; => 1
(:a {:a 1 :b 2}) ;; => 1
(:c {:a 1 :b 2} "can't find") ;; => "can't find"
({:a 1 :b 2} :a) ;; => 1
(get [3 2 1] 0) ;; => 3
(get '(3 2 1) 0) ;; => nil
(nth [3 2 1] 0) ;; => 3
(nth '(3 2 1) 0) ;; => 3
(get #{:a :b} :a) ;; => :a
(contains? #{:a :b} :a) ;; => true

;; get-in
(get-in {:a 0 :b {:c "ho hum"}} [:b :c]) ;; => "ho hum"

;; go
(require '[clojure.core.async :refer :all])
(do
  (go
    (dotimes )))

;; hash-map
(interleave [1 2 3] [4 5 6])

;; group-by
(group-by count ["a" "as" "aa" "qwer"])
;; => {1 ["a"], 2 ["as" "aa"], 4 ["qwer"]}

(frequencies [:a :a :b :b :b])
(defn group-by-02 []
  ;; 

  )

(frequencies [:a :a :b :b :b]) ;; => {:a 2, :b 3}
(map ){:a 2, :b 3}







;; hash-map 
(hash-map 1 2) ;; => {1 2}
(hash-map :b 3 :d 4) ;; => {:b 3, :d 4}

;; hash-set
(hash-set 1 2 3) ;; => #{1 3 2}
(hash-set [1 2 3]) ;; => #{[1 2 3]}
(apply hash-set [1 2 3]) ;; => #{1 3 2}

;; identity
(identity [1 2 3]) ;; => [1 2 3]
(identity 1) ;; => 1
(map identity {:a 1}) ;; => ([:a 1])
(type (map identity {:a 1})) ;; => clojure.lang.LazySeq
(set (map identity {:a 1})) ;; => #{[:a 1]}
(vec (map identity {:a 1})) ;; => [[:a 1]]
(into [] (map identity {:a 1})) ;; => [[:a 1]]

;; if-let
(defn if-let-demo [arg]
  (if-let [_ arg]
    "then"
    "else"))
(if-let-demo 1) ;; => "then" 
(if-let-demo nil) ;; => "else"
(if-let-demo false) ;; => "else"
(if-let-demo true) ;; => "then"

;; includes?
(clojure.string/includes? "abc" "b") ;; => true
(clojure.string/includes? "abc" "B") ;; => false

;; int
(int 3.2)

;; interleave
(interleave [:a :b] [1 2]) ;; => (:a 1 :b 2)
(interleave [:a :b] [1 2 3]) ;; => (:a 1 :b 2)
(interleave [:a :b] [1]) ;; => (:a 1)
(zipmap [:a :b] [1 2 3]) ;; => {:a 1, :b 2}
(zipmap [:a :b] [1]) ;; => {:a 1}

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

;; join
(clojure.string/join ["w" "o" "r" "d"]) ;; => "word"
(apply str ["w" "o" "r" "d"]) ;; => "word"

;; juxt
((juxt :a :b) {:a 1 :b 2 :c 3 :d 4}) ;; => [1 2]

;; keys
(keys {:a 1 :b 2}) ;; => (:a :b)

;; lazy-seq
(defn pos-nums [n]
  (lazy-seq (cons n (pos-nums (inc n)))))
(take 5 (pos-nums 2)) ;; => (2 3 4 5 6)
(defn abc [n]
  (lazy-seq (cons n (abc (inc n)))))
(take 5 (abc 11)) ;; => (11 12 13 14 15)
(defn repeat-2 [n]
  (lazy-seq (cons n (repeat-2 n))))
(take 3 (repeat-2 1))


;; lower-case
(clojure.string/lower-case "AB") ;; => "ab"

;; macro
(defmacro infix [symbols]
  (list (second symbols)
        (first symbols)
        (last symbols)))
;; (infix '(1 + 2)) ;; ERROR!
(infix (1 + 2)) ;; => 3
(macroexpand '(infix (1 + 2))) ;; => (+ 1 2)
(defmacro when [test & body]
  (list 'if test (cons 'do body)))
(when (even? 2) (+ 1 2)) ;; => 3
(macroexpand '(when (even? 2) (+ 1 2) (print "hi!")))
;; => (if (even? 2) (do (+ 1 2) (print "hi!")))

;; map
;; (map f) (map f coll) (map f c1 c2) (map f c1 c2 c3) (map f c1 c2 c3 & colls)
(map inc [1 2 3 4 5]) ;; => (2 3 4 5 6)
(map + [1 2 3] [4 5 6]) ;; => (5 7 9)
(map + [1 2 3] (iterate inc 1)) ;; => (2 4 6)
(map + #{1 2 3}) ;; => (1 3 2)

;; mapcat
(map #(repeat 2 %) [1 2]) ;; => ((1 1) (2 2))
(concat [[1 2] [3 4]]) ;; => ([1 2] [3 4])
(apply concat [[1 2] [3 4]]) ;; => (1 2 3 4)
(mapcat #(repeat 2 %) [1 2]) ;; => (1 1 2 2)

;; memoize
(defn original [n]
  (print "original run")
  (+ n 10))
(def original-memoized (memoize original))
(original-memoized 2) ;; => 12 ;; prints "original run"
(original-memoized 2);; => 12
(original-memoized 2);; => 12 
(original-memoized 5) ;; => 15 ;; prints "original run

;; merge
(merge {:a 1} {:b 9 :d 4}) ;; => {:a 1, :b 9, :d 4}

;; merge-with
;; (merge-with f & maps)
(merge-with + {:a 1 :b 2} {:a 9 :c 0}) ;; => {:a 10, :b 2, :c 0}
(merge-with cons {:a 1 :b 2} {:a 9 :c 0})

;; mod
(mod 10 7) ;; => 3

;; min
(min 3 4 5) ;; => 3
(min 3.12 4 5) ;; => 3.12

;; not-equal
(not= 2 3) ;; => true
(not= 3 3 3) ;; => false
(not= 3 3 4 4) ;; => true

;; partial
(def add-hundred (partial + 100)) ;; => #'focl.core/add-hundred
(add-hundred 1) ;; => 101 
(add-hundred 1 2 3) ;; => 106 
(+ 100 1 2 3) ;; => 106
(def add-some-and (partial + 1 2 3))
(add-some-and 4 5) ;; => 15

;; partition
(partition 2 [1 2 3 4 5 6]) ;; => ((1 2) (3 4) (5 6))

;; partition-all
(partition-all 4 [1 2 3 4 5 6]) ;; => ((1 2 3 4) (5 6))
(partition-all 3 [0 1 :a "x" 3 [7 8] '(:g 7)]) ;; => ((0 1 :a) ("x" 3 [7 8]) ((:g 7)))
(partition-all 2 4 [0 1 2 3 4 5 6 7 8 9]) ;; => ((0 1) (4 5) (8 9))

;; partition-by
(partition-by odd? [1 1 2 2 3 3]) ;; => ((1 1) (2 2) (3 3))
(partition-by odd? [1 1 2 2 1 1]) ;; => ((1 1) (2 2) (1 1))
(partition-by identity [1 1 2 3 4]) ;; => ((1 1) (2) (3) (4))
(partition-by identity "Leerrroyy")
;; => ((\L) (\e \e) (\r \r \r) (\o) (\y \y))

;; parseint
(Integer/parseInt "123") ;; => 123

;; persistent!
(def t (transient {:a 1})) ;; => #'focl.core/t
(assoc! t :b 2) ;; -> shows message regarding type
(count t) ;; => 2
(persistent! t) ;; can be run only once
(comment (assoc1 t :c 3)) ;; gets error as persistent 

;; plus quote
(+' 1 2) ;; => 3
(apply +' (range 10000000000000
                 10000000001000))
;; => 10000000000499500

;; pmap
(pmap inc [1 2 3]) ;; => (2 3 4)
(time (pmap inc [1 2 3]))
;; => (2 3 4)
;; "Elapsed time: 0.872472 msecs"
(time (map inc [1 2 3]))
;; => (2 3 4)
;; "Elapsed time: 0.081481 msecs"

;; A function that simulates a long-running process by calling Thread/sleep:
(defn long-running-job [n]
    (Thread/sleep 3000) ; wait for 3 seconds
    (+ n 10))

;; Use `doall` to eagerly evaluate `map`, which evaluates lazily by default.

;; With `map`, the total elapsed time is just under 4 * 3 seconds:
(time (doall (map long-running-job (range 4))))
"Elapsed time: 11999.235098 msecs"
(10 11 12 13)

;; With `pmap`, the total elapsed time is just over 3 seconds:
(time (doall (pmap long-running-job (range 4))))
"Elapsed time: 3200.001117 msecs"
(10 11 12 13)

;; promise
(def my-promise (promise))
my-promise ;; => #<Promise@591c7f49: :not-delivered>
(realized? my-promise) ;; => false
(deliver my-promise 3) ;; => nil
(realized? my-promise) ;; => true
my-promise ;; => #<Promise@7795674b: 3> ;; ready 
@my-promise ;; => 3

;; range
(range 3) ;; => (0 1 2)
(range 3 6) ;; => (3 4 5)
(range 3 12 3) ;; => (3 6 9)
(range 5 2 -1) ;; => (5 4 3)
(take 3 (range)) ;; => (0 1 2)

;; read-string
(type (read-string "+")) ;; => clojure.lang.Symbol
((eval (read-string "+")) 1 2 3) ;; => 6
(type (quote +)) ;; => clojure.lang.Symbol
((eval (quote +)) 1 2 3) ;; => 6

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
(defn reduce-2 [f start coll]
  (loop [v start
         coll coll]
    (if (empty? coll)
      v
      (recur (f v (first coll)) (rest coll)))))
(reduce-2 + 1 [2 3]) ;; => 6
(reduce-2 * 10 [2 3]) ;; => 60



;; repeat
(repeat 3 "a") ;; => ("a" "a" "a")
(defn repeat-2 [n x]
  (take n (iterate identity x)))
(repeat-2 3 "a") ;; => ("a" "a" "a")

;; repeatedly
(take 3 (repeatedly (fn [] "a"))) ;; => ("a" "a" "a")

;; reset!
(def age (atom 10)) ;; => #'focl.core/age
(reset! age 13) ;; => 13
@age ;; => 13

;; select-keys 
(select-keys {:a 1 :b 2 :c 3} [:a :b]) ;; => {:a 1, :b 2}

;; set
(set [1 1 2 2]) ;; => #{1 2}

;; some
;; true if any value meets predicate
(some even? [1 2 3 4 5 6]) ;; => true
(some #(when (even? %) %) [1 2 3 4 5]) ;; => 2
(some neg? [-1 2 5]) ;; => true

;; sorted-map
;; keys must be the same type, so ordered
(sorted-map 3 4 1 2) ;; => {1 2, 3 4}
(sorted-map :z 0, :a 28, :b 35) ;; => {:a 28, :b 35, :z 0}
(hash-map "b" 1 :a 2) ;; => {"b" 1, :a 2}
(sorted-map "c" 2 "b" 3) ;; => {"b" 3, "c" 2}
(sorted-map 3 "a" 1 :z) ;; => {1 :z, 3 "a"}

;; split
;; (split s re) (split s re limit)
(require '[clojure.string :refer [split]])
(split "Lisp is great!" #" ") ;; => ["Lisp" "is" "great!"]
(split "Lisp!" #"") ;; => ["L" "i" "s" "p" "!"]

;; swap!
(def age (atom 10)) ;; => #'focl.core/age
(swap! age inc) ;; => 12
(swap! age #(* 2 %)) ;; => 48

;; syntax quoting
;; use backtick
`(+ 1 2) ;; => (clojure.core/+ 1 2)
`(+ 1 (+ 1 1)) ;; => (clojure.core/+ 1 (clojure.core/+ 1 1))
`(+ 1 ~(+ 1 1)) ;; => (clojure.core/+ 1 2)

;; take
(take 2 [1 2 3 4]) ;; => (1 2)
(take 3 (repeat "a")) ;; => ("a" "a" "a")
(take 3 (iterate inc 6)) ;; => (6 7 8)

;; take-while
;; take from the beginning
(take-while neg? [-2 -1 0 1 2]) ;; => (-2 -1)
(filter neg? [-2 -1 0 1 2]) ;; => (-2 -1)
(take-while even? [-2 -1 0 1 2]) ;; => (-2)
(take-while even? [2 4 6 5]) ;; => (2 4 6)
(filter even? [1 2 4 6 5]) ;; => (2 4 6)
(take-while even? [1 2 4 6 5]) ;; => ()

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

;; time
(time (take 5 (iterate inc 1)))
;; => (1 2 3 4 5)
;; prints "Elapsed time: 0.047736 msecs"

;; transient
(transient [1 2 3]) ;; -> shows message regarding type

;; true?
(true? [true false]) ;; => false
(true? [true true])

;; union 
(require '[clojure.set :refer [union]])
(union #{1 2} #{2 3}) ;; => #{1 3 2}

;; unquote
;; in syntax quoting
`(+ 1 2) ;; => (clojure.core/+ 1 2)
`(+ 1 (+ 1 1)) ;; => (clojure.core/+ 1 (clojure.core/+ 1 1))
`(+ 1 ~(+ 1 1)) ;; => (clojure.core/+ 1 2)

;; update-in
(update-in {:a {:b 2}} [:a :b] inc) ;; => {:a {:b 3}}

;; unquote
(def a 3) ;; => #'focl.core/a
'(a a) ;; => (a a)
`(a ~a) ;; => (a ~a)

;; upper-case
(clojure.string/upper-case "ab") ;; => "AB"

;; quot
;; quot[ient] of dividing numerator by denominator
(quot 5 2) ;; => 2
(quot 10 3) ;; => 3

;; quote
;; use apostrophy
'(+ 1 2) ;; => (+ 1 2)
'(+ 1 ~(+ 1 1)) ;; => (+ 1 ~(+ 1 1)) ;; unquote doesn' work

;; zipmap
(zipmap [:a :b :c] [1 2 3]) ;; => {:a 1, :b 2, :c 3}
(zipmap [:a :b :c] [1 2 3 4]) ;; => {:a 1, :b 2, :c 3}
(zipmap [:html :body] (repeat {:m 0 :p 0})) ;; => {:html {:m 0, :p 0}, :body {:m 0, :p 0}}
(zipmap [:a :b :c] (repeat 0)) ;; => {:a 0, :b 0, :c 0}
