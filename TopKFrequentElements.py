'''
TC: O(n) - Iterating over the nums array - length of nums array - worst case will be O(n^2)
            incase we need to have all the elements populated
SC: O(n) - creating hashmaps for storing frequency map
'''
import collections
from typing import List

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hmap = collections.defaultdict(int)
        max_, min_ = -float('inf'), float('inf')
        for i, num in enumerate(nums):
            hmap[num] += 1
        
        fmap = collections.defaultdict(list)
        for key, val in hmap.items():
            fmap[val].append(key)
            if val > max_:
                max_ = val
            if val < min_:
                min_ = val
        
        ans = []
        for i in range(max_, min_-1, -1):
            for num in fmap[i]:
                ans.append(num)
                k -= 1
                if k == 0:
                    return ans
s = Solution()
print(s.topKFrequent([1,1,1,2,2,3], 2))
print(s.topKFrequent([1], 1))
print(s.topKFrequent([1,1,1,2,2,3], 3))