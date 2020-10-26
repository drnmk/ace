# https://leetcode.com/problems/longest-palindromic-substring/

class Solution:
    
    def find(self, s, left, right):
        p = ''
        while 0 <= left < len(s) and 0 <= right < len(s) and left <= right and str(s[left:right:+1]) == str(s[right-1:left-1:-1]):
            if len(p) < len(s[left:right:+1]):
                p = s[left:right:+1]
            left -= 1
            right += 1
        return p
    
    def longestPalindrome(self, s):
        if len(s) == 1: return s
        if len(s) == 2 and s[0] == s[1]: return s
        m = ""
        for i in range(len(s)):
            if i == 0 or i == (len(s) - 1):
                m = max(m, [s[i]], key=lambda x: len(x))                
            else:
                odd = self.find(s, (i-1), i)
                even = self.find(s, (i-1), (i+1))
                m = max([m, odd, even], key=lambda x: len(x))
        return ''.join(m)

trial = Solution()
trial.longestPalindrome("ccc")
trial.find("ccc", 0, 1)
