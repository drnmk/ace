(ns focl.027)

;; Palindrome Detector
;; Difficulty: Easy
;; Topics: seqs
;; Write a function which returns true if the given sequence is a palindrome.
;; Hint: "racecar" does not equal '(\r \a \c \e \c \a \r)

(defn f [seq]
  (let [r (if (string? seq)
            (clojure.string/join (reverse seq))
            (reverse seq))]
    (if (= seq r)
      true
      false)))

(false? (f '(1 2 3 4 5))) ;; => true
(true? (f "racecar")) ;; => true
(true? (f [:foo :bar :foo])) ;; => true
(true? (f '(1 1 3 3 1 1))) ;; => true
(false? (f '(:a :b :c))) ;; => true
