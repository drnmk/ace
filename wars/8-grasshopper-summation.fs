module Trials

(*
Write a program that finds the summation of every number from 1 to num. The number will always be a positive integer greater than 0.
For example:
summation(2) -> 3
1 + 2
summation(8) -> 36
1 + 2 + 3 + 4 + 5 + 6 + 7 + 8    
*)

// solution 1
let summation1 n =
    let mutable sum = 0
    for i in 0..n do
        sum <- sum + i
    sum

let trial1 = summation1 8

// solution 2
let summation2 n =
    let rec add i n = 
        if i > n then 0
        else i + (add (i+1) n)
    add 0 n
    
let trial2 = summation2 8

// solution 3
let summation3 n =
    let rec down i n = 
        if i <= 0 then 0
        else i + (down (i - 1) n)
    down n n

let trial3 = summation3 8

// solution 4
let summation4 n = 
    n * (n + 1) / 2

let trial4 = summation4 8

// solution 5
let summation5 n =
    [0..n] |> List.sum

let trial5 = summation5 8