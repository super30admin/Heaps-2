# HEAP APPROACH
# TIME COMPLEXITY: O(n) + O(n log k)
# SPACE COMPLEXITY: O(n)
from heapq import *


class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        # Build a map of numbers and frequency
        freq_map = collections.Counter(nums)
        # Initialize a minheap
        minheap = []

        # For every number and it's frequency, push (freq, num) in the heap till size of heap is k
        # If size exceeds k, pop elements from the heap
        for num, freq in freq_map.items():
            heappush(minheap, (freq, num))
            if len(minheap) > k:
                heappop(minheap)
        # We are left with the k most frequent elements in the heap
        res = []
        for freq, num in minheap:
            res.append(num)

        return res
