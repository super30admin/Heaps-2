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
        
        
        
# time cpomplexity - O(N)
# Approach - Bucket SORT

import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        map={}
        bucket=[None for i in range(len(nums)+1)]
        for i in nums:
            if i in map:
                map[i]+=1
            else:
                map[i]=1
            
            
 
        
        for key in map.keys():
            freq=map[key]
            if bucket[freq]==None:
                bucket[freq]=[]
            bucket[freq].append(key)
            
        res=[]
        
        for i in range(len(bucket)-1,0,-1):
            if len(res)<k:
                if bucket[i]!=None:
                    res+=bucket[i]
            else:
                break
        if len(res)<=k:
            return res
        return res[:k]
                    
            
        
        
        
        
        
