# Approach - since we care about k elements out of N we can use heaps
# Based on freq push to min heap and pop smaller number up until size k

# Time - O(N) + O(N log K) ~= O(N log K)

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        # min heap solution
        min_heap = []
        count = collections.Counter(nums) # O(N)
        
        for num, freq in count.items(): # O(N log K)
            heappush(min_heap, (freq, num))
            
            if len(min_heap) > k:
                heappop(min_heap)
              
        result = []
                
        for freq, num in min_heap:
            result.append(num)
            
        return result
        
        
        
        
        
# Brute Force
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        dict = Counter(nums) # O(N)

        k_freq = dict.most_common(k) 
        for val in k_freq:
            result.append(val[0])
            
        return result
                