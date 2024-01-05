'''
hashMap
key: number in list
value: the count of the number

create a min heap of (frequency, number) size = k

so at the end we will have top k frequent elements in the heap
TC: O(nlogk)
SC: O(k+k+l) // for heapsize and result size l size which is size of hashMap

'''


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hashMap = collections.defaultdict(int)
        result = []
        
        for num in nums:
            hashMap[num] += 1
        
        #heap
        h = []
        
        for key, value in hashMap.items():
            #need min heap since it is top k frequent
            heapq.heappush(h, (value, key))
            
            if len(h) > k:
                heapq.heappop(h)
                
        while h:
            result.append(heapq.heappop(h)[1])
        
        return result
        