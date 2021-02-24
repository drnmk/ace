;; #107
;; Simple closures
;; Difficulty: Easy
;; Topics: higher-order-functions math
;; Lexical scope and first-class functions are two of the most basic building blocks of a functional language like Clojure. When you combine the two together, you get something very powerful called lexical closures. With these, you can exercise a great deal of control over the lifetime of your local bindings, saving their values for use later, long after the code you're running now has finished.
;; It can be hard to follow in the abstract, so let's build a simple closure. Given a positive integer n, return a function (f x) which computes xn. Observe that the effect of this is to preserve the value of n for use outside the scope in which it is defined.
;; (= 256 ((__ 2) 16) ((__ 8) 2))
;; (= [1 8 27 64] (map (__ 3) [1 2 3 4]))
;; (= [1 2 4 8 16] (map #((__ %) 2) [0 1 2 3 4]))

;; pow
(Math/pow 7 2) ;; => 49.0
;; int
(int 3.3) ;; => 3
(int 4.9) ;; => 4
(int -0.8) ;; => 0
(int -1.1) ;; => -1

;; trial 1
(defn f1 [a]
  (fn [b] (int (Math/pow b a))))
(= 256 ((f1 2) 16) ((f1 8) 2)) ;; => true
(= [1 8 27 64] (map (f1 3) [1 2 3 4])) ;; => true
(= [1 2 4 8 16] (map #((f1 %) 2) [0 1 2 3 4])) ;; => true
