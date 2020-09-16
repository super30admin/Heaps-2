# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
# https://leetcode.com/problems/top-k-frequent-elements/submissions/ 
# Time Complexity : O(nlogk)
# Space Complexity : O(n)
import heapq
class Solution:
    def topKFrequent(self, nums, T):
        d = {}
        for i in range(len(nums)): # O(n)
            if nums[i] not in d:
                d[nums[i]] = 0 
            d[nums[i]] += 1
        
        pq = []
        for k,v in d.items():
            heapq.heappush(pq, (v, k))  # O(klogk)
            if len(pq) > T:
                heapq.heappop(pq)
        
        result = [0] * T
        for i in range(len(result)-1, -1, -1): #O(k)
            curr = heapq.heappop(pq)
            result[i] = curr[1]
        
        return result

# Time Complexity : O(n)
# Space Complexity : O(n)
class Solution:
    def topKFrequent(self, nums, k):
        d = {}
        for i in range(len(nums)):
            if nums[i] not in d:
                d[nums[i]] = 0 
            d[nums[i]] += 1
        
        result = [None for _ in range(len(nums)+1)]
        for key,v in d.items():
            if result[v] is None:
                result[v] = []
            result[v].append(key)
        
        res = []
        for j in range(len(result)-1, -1, -1):
            if result[j] is not None and k > 0:
                for num in result[j]:
                    if k > 0:
                        res.append(num)
                        k -= 1 
                    else:
                        break 
        
        return res
    
if __name__ == "__main__":
    s= Solution()
    res = s.topKFrequent([1,1,1,2,2,3], 2)
    assert res == [1,2]