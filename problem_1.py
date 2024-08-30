# Time O(NlogK)
# Space O(N)
import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if not nums:
            return []
        counter = {}
        min_heap = []
        for num in nums:
            counter[num] = counter.get(num,0) + 1
        for key, value in counter.items():
            heapq.heappush(min_heap, (value, key))
            # remove excess element
            if len(min_heap) > k:
                heapq.heappop(min_heap)
        result = [key for value, key in min_heap]
        return result
        