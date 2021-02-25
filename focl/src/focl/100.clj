;; https://www.4clojure.com/problem/100

;; trial 1
(sort [5 3 7]) ;; => (3 5 7)
(first [3 5 7]) ;; => 3
(take 5 (iterate #(+ % 3) 3)) ;; => (3 6 9 12 15)
(defn divisible-by-all [x all]
  (apply = true 
   (map #(if (= 0 (mod x %)) true false) all)))
(defn f1 [& nums]
  (let [max-cm (apply * nums)
        small (-> nums sort first)
        applicants (take (/ max-cm small)
                         (iterate #(+ % small) small))]
    (->> applicants
      (filter #(divisible-by-all % nums))
      (sort)
      (first))))
(== (f1 2 3) 6) ;; => true
(== (f1 5 3 7) 105) ;; => true
(== (f1 1/3 2/5) 2) 
(== (f1 3/4 1/6) 3/2)
(== (f1 7 5/7 2 3/5) 210)
