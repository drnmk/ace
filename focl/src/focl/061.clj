;; #61
;; Map Construction
;; Difficulty: Easy
;; Topics: core-functions
;; Write a function which takes a vector of keys and a vector of values and constructs a map from them.
;; (= (__ [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})
;; (= (__ [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})
;; (= (__ [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})
;; Special Restrictions: zipmap


;; zipmap
(zipmap [:a :b :c] [1 2 3]) ;; => {:a 1, :b 2, :c 3}
(zipmap [:a :b :c] [1 2 3 4]) ;; => {:a 1, :b 2, :c 3}
(zipmap [:html :body] (repeat {:m 0 :p 0})) ;; => {:html {:m 0, :p 0}, :body {:m 0, :p 0}}
(zipmap [:a :b :c] (repeat 0)) ;; => {:a 0, :b 0, :c 0}
;; conj
(conj {:a 1 :b 2} {:c 3}) ;; => {:a 1, :b 2, :c 3}
;; hash-map
(hash-map 1 2) ;; => {1 2}
(hash-map :b 3 :d 4) ;; => {:b 3, :d 4}

;; trial 1
(defn f1 [coll1 coll2]
  (let [shorter (min (count coll1) (count coll2))]
    (loop [i 0
           m {}]
      (if (<= shorter i)
        m
        (recur (inc i)
               (conj m {(get coll1 i) (get coll2 i)}))))))
(= (f1 [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3}) ;; => true
(= (f1 [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"}) ;; => true 
(= (f1 [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"}) ;; => true

;; trial 2
;; reference:
;; https://gist.github.com/SegFaultAX/3607101
(interleave [:a :b :c] [1 2 3]);; => (:a 1 :b 2 :c 3)
(apply hash-map '(:a 1 :b 2 :c 3)) ;; => {:c 3, :b 2, :a 1}
(defn f2 [coll1 coll2]
  (apply hash-map (interleave coll1 coll2)))
(= (f2 [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3}) ;; => true
(= (f2 [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"}) ;; => true
(= (f2 [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"}) ;; => true
