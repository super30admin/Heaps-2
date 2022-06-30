#Time Complexity: O(N)
#Space Complexity: O(N)
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        d = {}
        
        for i in nums:
            if i in d:
                d[i] +=1
            else:
                d[i] = 1
     
        d = sorted(d, key=d.get, reverse=True)
        
        d= d[0:k]
        
        return d