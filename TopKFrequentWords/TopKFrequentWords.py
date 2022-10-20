class Solution:
    def topKFrequent(self, words, k: int):
        seen = {}
        for word in words:
            seen[word] = seen.get(word, 0) + 1
        
        l = [(seen[key], key) for key in seen.keys()]
        
        res = sorted(l, key = lambda x : (-x[0], x[1]))
        
        return [res[i][1] for i in range(k)]