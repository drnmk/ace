"""
https://leetcode.com/problems/defanging-an-ip-address/
1108. Defanging an IP Address
Easy
Given a valid (IPv4) IP address, return a defanged version of that IP address.
A defanged IP address replaces every period "." with "[.]".
Example 1:
Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"
Example 2:
Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"
Constraints:
The given address is a valid IPv4 address.
"""

# trial 1

from typing import List, Dict, Tuple, Sequence

def determine(x):
    if x == '.': return "[.]"
    else: return x
                
class Solution:
    def defangIPaddr(self, address: str) -> str:
        defanged = ''
        for s in address:
            defanged = defanged + determine(s)
        return defanged

t = Solution()
t.defangIPaddr("255.100.50.0")
