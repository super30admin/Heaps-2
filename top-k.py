# topKFrequent:
# - Count frequencies using Counter.
# - Use a max heap (via negating frequency) to extract k most frequent elements.

# TC: O(N log N), N = number of unique elements (heapify + k pops).
# SC: O(N) for frequency map and heap.


import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        count = Counter(nums)
        heap = []
        for num, freq in count.items():
            heap.append((-freq, num))
        heapq.heapify(heap)
        res = []
        for i in range(k):
            freq, num = heapq.heappop(heap)
            res.append(num)
        return res
        

