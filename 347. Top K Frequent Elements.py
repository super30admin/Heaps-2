#Time Complexity:O(nlogn)
#Space Complexity:O(nlogn)

from collections import Counter
import heapq
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        ctr = Counter(nums)
        heap = []
        for key, val in ctr.items():
            heapq.heappush(heap, (val, key))
            if len(heap) > k:
                heapq.heappop(heap)
        return [k for v,k in heap]
            
        