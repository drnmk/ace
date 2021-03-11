;; https://www.hackerrank.com/challenges/fp-hello-world-n-times/problem

(def hello_word_n_times 
  (for [s (repeat (Integer/parseInt (read-line)) "Hello World")] (prn s)))
