;; https://leetcode.com/problems/two-sum/

;; solution 1
(defn two-sum [nums target index pool]
  (let [value (get nums index)
        comple (- target value)
        does-nums-have-comple? (.contains nums comple)
        comple-index (if does-nums-have-comple?
                       (.indexOf nums comple) nil)
        indices-not-same? (not= index comple-index)]
    (if (and does-nums-have-comple? indices-not-same?)
      [index comple-index]
      (two-sum nums
               target
               (+ index 1)
               (merge pool {(keyword (str comple))
                            (.indexOf nums comp)})))))
(def trial1 (two-sum [3 2 4] 6 0 nil)) ;; -> [1 2]
(def trial2 (two-sum [2 7 11 15] 9 0 nil)) ;; -> [0 1]