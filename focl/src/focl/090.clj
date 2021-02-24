;; #90
;; Cartesian Product
;; Difficulty: Easy
;; Topics: set-theory
;; Write a function which calculates the Cartesian product of two sets.
(comment  
  (= (__ #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
     #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
       ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
       ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]})
  (= (__ #{1 2 3} #{4 5})
     #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})
  (= 300 (count (__ (into #{} (range 10))
                    (into #{} (range 30))))))

;; trial 1
;; rf: https://gist.github.com/SegFaultAX/3607101
(defn f1 [a b]
  (set (for [x a y b] [x y])))
(= (f1 #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
   #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
     ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
     ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]}) ;; => true
(= (f1 #{1 2 3} #{4 5})
   #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}) ;; => true
(= 300 (count (f1 (into #{} (range 10))
                  (into #{} (range 30))))) ;; => true
