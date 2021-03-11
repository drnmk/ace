;; https://www.4clojure.com/problem/19

;; 1
(defn f1 [coll]
  (nth coll (- (count coll) 1)))

(= (f1 [1 2 3 4 5]) 5) ;; => true
(= (f1 '(5 4 3)) 3) ;; => true
(= (f1 ["b" "c" "d"]) "d") ;; => true

;; 2
(defn f2 [coll]
  (-> coll
      reverse
      first))
(= (f2 [1 2 3 4 5]) 5) ;; => true
(= (f2 '(5 4 3)) 3) ;; => true
(= (f2 ["b" "c" "d"]) "d") ;; => true
