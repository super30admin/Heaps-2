# TC: O(NlogK)
# SC : O(N)
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hashmap = {}
        hq = []
        for num in nums:
            if num not in hashmap:
                hashmap[num] = 1
                
            else:
                hashmap[num]+=1               
        
        
        for num,count in hashmap.items():
            heappush(hq,(count,num))
            if len(hq) > k:
                heappop(hq)
                
        result = []
        
        for i in range(len(hq)):
            result.append(hq[i][1])
            
        return result
    
# TC : O(N)
# SC: O(N)
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        hmap = {}
        bucket = [[] for i in range(len(nums) + 1)]
        for num in nums:
            hmap.update({num : hmap.get(num, 0) + 1})
        
        for key, value in hmap.items():
            bucket[value].append(key)
        
        res = []
        for i in range(len(bucket), -1, -1):
            if len(bucket[i - 1]) != 0:
                for element in bucket[i - 1]:
                    res.append(element)
            if len(res) == k:
                break
        return res
        