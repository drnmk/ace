"""
1281. Subtract the Product and Sum of Digits of an Integer
Easy
Given an integer number n, return the difference between the product of its digits and the sum of its digits.
Example 1:
Input: n = 234
Output: 15 
Explanation: 
Product of digits = 2 * 3 * 4 = 24 
Sum of digits = 2 + 3 + 4 = 9 
Result = 24 - 9 = 15
Example 2:
Input: n = 4421
Output: 21
Explanation: 
Product of digits = 4 * 4 * 2 * 1 = 32 
Sum of digits = 4 + 4 + 2 + 1 = 11 
Result = 32 - 11 = 21
Constraints:
1 <= n <= 10^5
"""

# trial 1
from typing import List, Dict, Tuple, Sequence
class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        nums = []
        for s in str(n): nums.append(int(s))
        prd = 1
        sm = 0
        for n in nums:
            prd = prd * n
            sm = sm + n
        return (prd - sm)
trial = Solution()
trial.subtractProductAndSum(234)
