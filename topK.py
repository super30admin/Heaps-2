"""
TC: O(n logk)
SP: O(n+k)
Counter's most common internally uses heap for finding top k
"""
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counter = Counter(nums)
        top_k = counter.most_common(k)
        res = []
        for k, _ in top_k:
            res.append(k)
        return res
#using heap
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counter = Counter(nums)
        pq = []
        for x, v in counter.items():
            heapq.heappush(pq, (v, x))
            if len(pq) > k:
                heapq.heappop(pq)
        res = []
        for v, x in pq:
            res.append(x)
        return res