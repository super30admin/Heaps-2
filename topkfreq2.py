# // Time Complexity :O(3n)
# // Space Complexity :O(maxfreq)
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
        maxx=-inf
        for i in nums:
            if i not in hmap.keys():
                hmap[i]=0
            hmap[i]+=1
            maxx=max(maxx,hmap[i])
        print(hmap)
        li=[[] for i in range(maxx+1)]
        for i in hmap.keys():
            li[hmap[i]].append(i)
        print(li)
        result=[]
        for i in range(maxx,0,-1):
            temp=li[i]
            for j in temp:
                result.append(j)
                k-=1
                print(k)
                if k == 0:
                    return result
        print(result)
            
            
            
       