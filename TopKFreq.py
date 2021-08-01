"""TC -> O(nlogk)
SC -> O(N) """
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        import heapq
        import collections
        minheap = []
        result = []
        count = collections.Counter(nums) 
        for num, freq in count.items():
            heapq.heappush(minheap, (freq, num))
            if len(minheap) > k:
                heapq.heappop(minheap)
        for freq, num in minheap:
            result.append(num)
        return result