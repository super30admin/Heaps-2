# Using Heap
# Time Complexity: O(n log(k))
# Space Complexity: O(n)
class FreqEle:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        
    def __lt__(self, other):
        if self.value == other.value:
            return self.key > other.key
        return self.value < other.value

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if k == len(nums):
            return nums
        hashmap = {}
        for num in nums:
            hashmap[num] = hashmap.get(num, 0) + 1
        
        pq = []
        for key, value in hashmap.items():
            heapq.heappush(pq, FreqEle(key, value))
            if len(pq) > k:
                heapq.heappop(pq)
                
        result = []
        print(pq)
        while pq:
            result.append(heapq.heappop(pq).key)
        return result
                

# Using Buckets
# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if k == len(nums):
            return nums
        hashmap = {}
        for num in nums:
            hashmap[num] = hashmap.get(num, 0) + 1
        print(hashmap)
        
        buckets = [None] * (len(nums) + 1)
        for key, value in hashmap.items():
            if buckets[value] == None:
                buckets[value] = list()
            buckets[value].append(key)
       
        result = []
        for i in range(len(buckets)-1,-1,-1):
            if buckets[i] != None:
                for j in range(len(buckets[i])-1, -1, -1):
                    if k > 0:
                        result.append(buckets[i][j])
                        k -= 1
        return result
            
        