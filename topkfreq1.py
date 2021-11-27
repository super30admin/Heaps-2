# // Time Complexity :O(nlogk)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


from heapq import heappop
from heapq import heappush
class CustomList:
    def __init__(self,tup):
        self.val=tup[1]
        self.freq=tup[0]
    def __lt__(self,other):
        return self.val<other.val
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hmap={}
        for i in nums:
            if i not in hmap.keys():
                hmap[i]=0
            hmap[i]+=1
        print(hmap)
        pq=[]
        for i in hmap.keys():
                print(i,k)
                heappush(pq,CustomList((i,hmap[i])))
                if len(pq)>k:
                    heappop(pq)
            
        result=[]
        for i in pq:
            result.append(i.freq)
        print(result)
        return result[::-1]
        