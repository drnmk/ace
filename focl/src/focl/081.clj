;; #81
;; Set Intersection
;; Difficulty: Easy
;; Topics: set-theory
;; Write a function which returns the intersection of two sets. The intersection is the sub-set of items that each set has in common.
;; (= (__ #{0 1 2 3} #{2 3 4 5}) #{2 3})
;; (= (__ #{0 1 2} #{3 4 5}) #{})
;; (= (__ #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})
;; Special Restrictions: intersection

;; intersection 
(clojure.set/intersection #{1 2 3} #{2 3 4}) ;; => #{3 2}

;; trial 1
;; reference:
;; https://gist.github.com/SegFaultAX/3607101
(filter even? #{1 2 3 4}) ;; => (4 2)
(contains? #{1 2 3} 2) ;; => true
(defn f1 [a b]
  (into #{} (filter #(contains? a %) b)))
(= (f1 #{0 1 2 3} #{2 3 4 5}) #{2 3}) ;; => true
(= (f1 #{0 1 2} #{3 4 5}) #{}) ;; => true
(= (f1 #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d}) ;; => true
