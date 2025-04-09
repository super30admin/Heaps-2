class Solution:
    # TC : O(nlogk)
    # SC : O(n)
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if nums is None:
            return []
        hmap = defaultdict(int)
        for num in nums:
            hmap[num] += 1
        heap = []
        for key,val in hmap.items():
            if len(heap) < k:
                heapq.heappush(heap,(val,key))
            else:
                heapq.heappushpop(heap,(val,key))
        res = []
        while len(heap) > 0:
            val,key = heapq.heappop(heap)
            res.append(key)
        return res
        