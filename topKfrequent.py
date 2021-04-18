class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        class Node:
            def __init__(self,freq,x):
                self.freq = freq
                self.x = x
                
            
            def __lt__(self,other):
                return self.freq<other.freq
        
        import heapq
        h = []
        x = {}
        for i in nums:
            if(i in x.keys()):
                x[i] += 1
            else:
                x[i] = 1
        
        for i in x.keys():
            n = Node(x[i],i)
            heapq.heappush(h,n)
            if(len(h)>k):
                heapq.heappop(h)
        
        
        o = []
        while(len(h)>0):
            o.append(heapq.heappop(h).x)
        
        return o
