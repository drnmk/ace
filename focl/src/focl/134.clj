(ns focl.134)

;; A nil key
;; Difficulty: Elementary
;; Topics: maps
;; Write a function which, given a key and map, returns true if the map contains an entry with that key and its value is nil.
;; (true?  (__ :a {:a nil :b 2}))
;; (false? (__ :b {:a nil :b 2}))
;; (false? (__ :c {:a nil :b 2}))

(def f
  (fn [k m]
    (if (contains? m k)
      (nil? (k m))
      false)))

(true? (f :a {:a nil :b 2})) ;; => true
(false? (f :b {:a nil :b 2})) ;; => true
(false? (f :c {:a nil :b 2})) ;; => true
