# Heaps-2

## Problem1: Top K Frequently Repeating Elements(https://leetcode.com/problems/top-k-frequent-elements/)

from collections import Counter
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]: 
        h={}
        maxi=float('-inf')
        for i in range(len(nums)):
            if nums[i] not in h:
                h[nums[i]]=0
            h[nums[i]]+=1
            maxi=max(maxi,h[nums[i]])
        
        h2=defaultdict(list)
        for i in h:
            h2[h[i]].append(i)
        res=[]
        while k>0:
            if maxi in h2:
                a=h2[maxi]
                for p in range(len(a)):
                    if k>0:
                        res.append(a[p])
                        k-=1
            maxi-=1
        return res