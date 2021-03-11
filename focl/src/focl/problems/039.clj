;; #39
;; Interleave Two Seqs
;; Difficulty:	Easy
;; Topics:	seqs core-functions
;; Write a function which takes two sequences and returns the first item from each, then the second item from each, then the third, etc.
;; (= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
;; (= (__ [1 2] [3 4 5 6]) '(1 3 2 4))
;; (= (__ [1 2 3 4] [5]) [1 5])
;; (= (__ [30 20] [25 15]) [30 25 20 15])
;; Special Restrictions: interleave

(defn f [a-coll b-coll]
  (let [shorter (min (count a-coll)
                     (count b-coll))]
    (loop [i 0
           l []]
      (if (>= i shorter)
        l      
        (recur (inc i)
               (conj l
                     (nth a-coll i)
                     (nth b-coll i)))))))

(= (f [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)) ;; => true 
(= (f [1 2] [3 4 5 6]) '(1 3 2 4)) ;; => true 
(= (f [1 2 3 4] [5]) [1 5]) ;; => true
(= (f [30 20] [25 15]) [30 25 20 15]) ;; => true
