# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
import heapq
class Solution:
    def topKFrequent(self, nums, T):
        d = {}
        for i in range(len(nums)):
            if nums[i] not in d:
                d[nums[i]] = 0 
            d[nums[i]] += 1
        
        pq = []
        for k,v in d.items():
            heapq.heappush(pq, (v, k))
            if len(pq) > T:
                heapq.heappop(pq)
        
        result = [0] * T
        for i in range(len(result)-1, -1, -1):
            curr = heapq.heappop(pq)
            result[i] = curr[1]
        
        return result
    
if __name__ == "__main__":
    s= Solution()
    res = s.topKFrequent([1,1,1,2,2,3], 2)
    assert res == [1,2]