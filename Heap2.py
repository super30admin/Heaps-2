#Time Complexity o(knlogn)
#Space Complexity o(k)
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hmap = Counter(nums)
        heap = []
       
        for a in hmap:
            heapq.heappush(heap,(hmap[a],a))
            if len(heap)>k:
                heapq.heappop(heap)
            
        res = []
        
        for a in heap:
            res.append(a[1])
        return res
            