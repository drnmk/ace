# https://leetcode.com/problems/two-sum/

# trial 1
from typing import List, Dict, Tuple, Sequence
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        pool = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in pool: return [pool[complement], i]
            else: pool[nums[i]] = i
trial = Solution()
trial.twoSum([2,7,11,15], 9)

# trial 2
from typing import List, Dict, Tuple, Sequence
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in nums:
                if nums.index(complement) != i:
                    return [i, nums.index(complement)]       
trial = Solution()
trial.twoSum([3,2,4], 6)

# trial 3
def two_sum(nums, target, pool):
    for index in range(len(nums)):
        val = nums[index]
        complement = target - val
        if complement in pool: 
            return [pool[complement], index]
        else: 
            pool[val] = index
            two_sum(nums, target, pool)
two_sum([3,2,4], 6, {})