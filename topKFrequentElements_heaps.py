'''
Time Complexity: 0(nlogk)
Space Complexity: 0(k)
Run on LeetCode: Yes
'''
import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        # initialize a minHeap list
        heapList = []
        
        # maintain a dictionary
        numsDict = {}
        
        # iterate the nums
        for num in nums:
            if num not in numsDict:
                numsDict[num] = 1
            else:
                numsDict[num] += 1
        
        # maintain a minHeap of size k, extract min from the heap as soon as count breeches k
        count = 0
        # tuple pair (count,key)
        for key in numsDict:
            pair = (numsDict[key],key)
            heapq.heappush(heapList,pair)
            count += 1
            
            if count > k:
                # extract min
                heapq.heappop(heapList)
        
        # return the result
        result = []
        for pair in heapList:
            result.append(pair[-1])
        
        # print(result)
        return result