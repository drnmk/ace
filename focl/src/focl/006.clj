(ns focl.006)

;; Intro to Vectors
;; Difficulty:	Elementary
;; Topics:	
;; Vectors can be constructed several ways. You can compare them with lists.
;; Note: the brackets [] surrounding the blanks __ are part of the test case.
;; (= [__] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))

(= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c)) ;; => true

;; refer to
;; https://clojure.org/guides/equality
