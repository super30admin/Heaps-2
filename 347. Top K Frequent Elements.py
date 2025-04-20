#time:O(nlog(n))
#space:O(n)
#min heap for sorting
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        heap=[]
        cmap= Counter(nums)
        for key, value in cmap.items():
            heapq.heappush(heap,(value,key))
            if len(heap) >k:
                heapq.heappop(heap)
        res= [element[1] for element in heap]
        return res
