# Time complexity: O(N log K)
# Space complexity: O(N)


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if not nums or len(nums) == 0:
            return []
        
        maxHeap = []
        dic = {}
        result = []
        for num in nums:
            if num not in dic:
                dic[num] = 1
            else:
                dic[num] += 1
                
        for key, value in dic.items():
            heapq.heappush(maxHeap,(-value, key))
            
        while k != 0:
            result.append(heapq.heappop(maxHeap)[1])
            k -= 1
            
        return result
