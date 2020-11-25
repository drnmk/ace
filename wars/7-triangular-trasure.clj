(defn triangular [n]
    (if (pos? n 0)
        0
        (/ (* n (+ n 1)) 2)))