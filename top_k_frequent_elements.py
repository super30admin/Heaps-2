# Time complexity - O(nlogk)
# Space complexity - O(n) # because of hashmap

# Approach - Create a frequency map of elements. Maintain a heap of size k, where elements are pushed based
# on value first, then the key, and you pop the elements when heap size > k. Finally, create a resulting
# array with the elements of heap.

from typing import List
import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if len(nums) == 1:
            return nums
        
        ls = [] # maintaining heap
        freqmap = {}
        for n in nums:
            if n not in freqmap:
                freqmap[n] = 1
            else:
                freqmap[n] += 1
        
        for key, val in freqmap.items():
            heapq.heappush(ls, (val, key))
            if len(ls) > k:
                heapq.heappop(ls)

        result = []
        for i in range(len(ls)):
            result.append(ls[i][1])
        return result