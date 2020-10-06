# https://leetcode.com/problems/contains-duplicate/

# solution 1
class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        return len(set(nums)) != len(nums)
trial = Solution()
trial.containsDuplicate([1,2,3,1])
trial.containsDuplicate([1,2,3,4])
trial.containsDuplicate([1,1,1,3,3,4,3,2,4,2])