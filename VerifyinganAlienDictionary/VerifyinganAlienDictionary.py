"""
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. 
The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, 
return true if and only if the given words are sorted lexicographically in this alien language.

https://leetcode.com/problems/verifying-an-alien-dictionary/description/
"""

class Solution:
    def isAlienSorted(self, words: list[str], order: str) -> bool:
        # if length is one, the array is garuntee sorted
        if len(words) < 2:
            return True
        # iterate through every word in words
        for i in range(len(words) -1):
            for j in range(min(len(words[i]), len(words[i + 1]))):
                first = order.index(words[i][j])
                second = order.index(words[i + 1][j])
                # if second is smaller than first, that means the order is wrong
                if first > second:
                    return False
                elif first < second:
                    break
                # if the following is the prefix of first word, the order is wrong
                # there is a case where they are the same word
                elif j == len(words[i + 1]) - 1 and len(words[i]) != len(words[i + 1]):
                    return False
        return True


