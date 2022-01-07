# Time Complexity: O(nlogk), where n - length of the input array
# Space Complexity: O(n) - Dict + O(k) - heap

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if not nums or len(nums) == 0:
            return []

        result = []

        # Dict to store frequency of the nums
        freqmap = defaultdict(int)
        for num in nums:
            freqmap[num] += 1

        # Maintain minheap of size k sorted based on frequency
        heap = []
        for key in freqmap:
            heapq.heappush(heap, (freqmap[key], key))
            if len(heap) > k:
                heapq.heappop(heap)

        # Return the elements from the heap
        while heap:
            freq, item = heapq.heappop(heap)
            result.append(item)

        return result