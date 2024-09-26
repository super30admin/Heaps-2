#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Nov 12 10:56:40 2019

@author: tanvirkaur
"""

# Priority Queue is used. pq.put(Priority, item) is used to put the items into the pq and pq.get() remove the item with the high priority and return the remaining items. 
# Time complexity = O(nlogK) because we are maintaing the pq of size k.
#space complexity = O(n+k)
import Queue as Q
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        result = []
        dict1= {}
        pq = Q.PriorityQueue()
        
        for num in nums:
            dict1[num] = dict1.get(num,0) + 1
        
        for key, value in dict1.items():
            pq.put((-value,key))
            if pq.qsize == k+1:
                pq.get()
        
        while(k>0):
            result.append(pq.get()[1])
            k+= -1
    
        return result