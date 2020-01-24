'''
Leetcode - 347. Top K Frequent Elements
Approach - create hash map and sort using priority queue.
time complexity - nlogn
'''
import heapq
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        
        map={}
        for i in range(len(nums)):
            if nums[i] in map:
                map[nums[i]]=map[nums[i]]+1
            else:
                map[nums[i]]=1
        
        pq=[]
        for i in map:
            temp=(map[i],i)
            if len(pq)>=k:
                heapq.heappushpop(pq,temp)
            else:
                heapq.heappush(pq,temp)
        return [pair[1] for pair in pq] 
        