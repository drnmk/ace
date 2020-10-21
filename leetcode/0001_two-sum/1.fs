// https://leetcode.com/problems/two-sum/

// trial 1 - NOT WORKING, NEED TO RESOLVE
type Dict = System.Collections.Generic.IDictionary<int, int>
let rec twoSum 
   (nums : int list) (target : int) (index : int) (pool : Dict)  = 
   let value = List.item index nums
   let complement = target - value 
   let isComplementIncluded = List.contains complement nums
   if isComplementIncluded
   then
      if index <> (List.findIndex (fun x -> x = complement) nums)
      then [index ; List.findIndex (fun x -> x = complement) nums]
      else       
         (pool.Add(complement, (List.findIndex (fun x -> x = complement) nums)))
         twoSum nums target (index + 1) pool
   else 
      (pool.Add(complement, (List.findIndex (fun x -> x = complement) nums)))
      twoSum nums target (index + 1) pool
let empty = dict [] : Dict 
let trial = twoSum [3;2;4] 6 0 empty
