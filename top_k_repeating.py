# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class BucketSortSolution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        fmap = collections.Counter(nums)

        min_r,max_r = float('inf'), 0

        rev_map = {}

        for num, freq in fmap.items():
            min_r = min(min_r, freq)
            max_r = max(max_r, freq)

            if freq not in rev_map:
                rev_map[freq] = []
            
            rev_map[freq].append(num)
        
        res = []
        for i in range(max_r, min_r-1, -1):
            if i in rev_map:
                nums = rev_map[i]
                for num in nums:
                    res.append(num)
                    if len(res) == k:
                        return res
                    
# Time Complexity : O(nlogk)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO
class HeapSolution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        min_heap = []
        freq_dist = Counter(nums)

        for num,count in freq_dist.items():
            if len(min_heap) == k:
                if count > min_heap[0][0]:
                    heapq.heappop(min_heap)
                    heapq.heappush(min_heap, (count,num))
            else:
                heapq.heappush(min_heap, (count,num))
        
        return [val for _,val in min_heap]
        