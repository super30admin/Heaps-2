#Time:O(nlogk)
#Space:O(k)
import heapq
from collections import Counter
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        dict_count = Counter(nums)
        
        if len(dict_count)==k:
            return [key for key,value in dict_count.items()]
        i=1
        heap = []
        
        for key,value in dict_count.items():
            if i<=k:
                heapq.heappush(heap,(value,key))
                i+=1
            else:
                if heap[0][0]<value:
                    heapq.heappop(heap)
                    heapq.heappush(heap,(value,key))
                i+=1
        ans = []
        while(heap):
            value,key=heapq.heappop(heap)
            ans.append(key)
        return ans