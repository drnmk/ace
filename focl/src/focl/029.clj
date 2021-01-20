(ns focl.029)

;; Get the Caps
;; Difficulty:	Easy
;; Topics:	strings
;; Write a function which takes a string and returns a new string containing only the capital letters.
;; (= (__ "HeLlO, WoRlD!") "HLOWRD")
;; (empty? (__ "nothing"))
;; (= (__ "$#A(*&987Zf") "AZ")

(defn f [s]
  (clojure.string/join 
   (filter 
    (fn [c] (Character/isUpperCase c))
    s)))

(= (f "HeLlO, WoRlD!") "HLOWRD") ;; => true
(empty? (f "nothing")) ;; => true
(= (f "$#A(*&987Zf") "AZ") ;; => true
