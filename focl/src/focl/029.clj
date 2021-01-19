(ns focl.029)

;; Get the Caps
;; Difficulty:	Easy
;; Topics:	strings
;; Write a function which takes a string and returns a new string containing only the capital letters.
;; (= (__ "HeLlO, WoRlD!") "HLOWRD")
;; (empty? (__ "nothing"))
;; (= (__ "$#A(*&987Zf") "AZ")

(def upper-cases "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
(first "abc")


(clojure.string/includes?  "abc" "b")



(= (__ "HeLlO, WoRlD!") "HLOWRD")
(empty? (__ "nothing"))
(= (__ "$#A(*&987Zf") "AZ")
