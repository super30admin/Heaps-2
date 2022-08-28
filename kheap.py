'''
time complexity: O(nlogk)
space complexity: O(k)

'''
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        
        from collections import Counter
        count = {}
        
        maxK = 0
        for n in nums:
            count[n]=1+count.get(n,0)
            maxK = max(maxK,count[n])
            
        res = []
        freq = [[] for i in range(maxK+1)]
        for key,value in count.items():
            freq[value].append(key)
            
        print(freq)  
        for i in range(len(freq)-1,0,-1):
            for n in freq[i]:
                res.append(n)
            if(len(res)==k):
                return res