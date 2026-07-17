"""
1. We first count frequencies of all numbers. Then we use a min heap to keep track of the top k frequent elements. 
2. We iterate through the frequency dictionary and for each element, we check if the size of the heap is less than k. 
3. If it is, we push the element onto the heap. If the size of the heap is equal to k, we check top element of heap - minimum and pop if it is less than current.

TC: O(nlogk)
SC: O(n)
"""

import collections
import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = collections.defaultdict(lambda:0)
        for x in nums:
            freq[x]+=1
        
        minHeap = []
        heapq.heapify(minHeap)
        for key,v in freq.items():
            if len(minHeap) < k:
                heapq.heappush(minHeap,[v,key])
            elif  v>minHeap[0][0]:
               
                heapq.heappop(minHeap)
                heapq.heappush(minHeap,[v,key])
        
        ans=[]

        for _ in range(k):
            v,key=heapq.heappop(minHeap)
            ans.append(key)
        
        return ans
  