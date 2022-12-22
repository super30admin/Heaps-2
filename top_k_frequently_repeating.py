""" 
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Time Complexity: O(n) for bucket sort approach 
Space Complexity: O(n) for bucket sort approach
"""
from collections import Counter
def topKfrequent(nums, k):
    
    counts = Counter(nums)
    buckets = {}
    min_freq, max_freq = len(nums), 0
    
    for num, count in counts.items():
        if count in buckets:
            buckets[count].append(num)
        else:
            buckets[count] = [num]
            
        min_freq = min(min_freq, count)
        max_freq = max(max_freq, count)
        
    result = []
    
    for i in range(max_freq, min_freq-1, -1):
        if i in buckets:
            for num in buckets[i]:
                result.append(num)
                if len(result) == k:
                    return result
                
    return []
    
    