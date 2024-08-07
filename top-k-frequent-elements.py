#tc = O(n)
#sc = O(n)
from typing import List, collections
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        first = collections.defaultdict(int)
        for num in nums:
            first[num]+=1
        
        second = collections.defaultdict(list)
        maxVal = -float('inf')
        minVal = float('inf')

        for key, val in first.items():
            if val > maxVal:
                maxVal = val
            if val < minVal:
                minVal = val
            second[val].append(key)
        
        result = []
        for val in range(maxVal, minVal-1, -1):
            for num in second[val]:
                result.append(num)
                k -= 1
                if k == 0:
                    return result
        


