# Time Complexity : O(N + KlogN)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Max Heap
# We iterate through all the N elements so that is O(N) and add it to a list.
# Then we heapify the heap which takes logN time and iterate through the k elements so that is O(K) and pop upto k elements from the heap so that is O(k).
# So total time complexity is O(N) + O(KlogN) which is better than O(Nlogk)

import heapq


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        dict = {}

        for i in nums:
            if i not in dict:
                dict[i] = 1
            else:
                dict[i] += 1

        heap = []
        res = []
        for key, val in dict.items():
            heap.append((-val, key))
        heapq.heapify(heap)
        for i in range(k):
            val, key = heapq.heappop(heap)
            res.append(key)
        return res