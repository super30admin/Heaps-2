from collections import defaultdict, Counter
import heapq
from typing import List


class Solution:

    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        """
            https://leetcode.com/problems/top-k-frequent-elements/
            Time Complexity - O(n)
            Space Complexity - O(n)
        """
        count = Counter(nums)
        arr = [[] for _ in range(len(nums) + 1)]
        for key, value in count.items():
            arr[value].append(key)
        result = []
        for bucket in reversed(range(0, len(nums) + 1)):
            result += arr[bucket]
            for num in arr[bucket]:
                if len(result) == k:
                    return result
                result.append(num)
        return result

    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        """
            https://leetcode.com/problems/top-k-frequent-elements/
            Time Complexity - O(nlogk)
            Space Complexity - O(n)
        """
        count = Counter(nums)
        pq = []
        for k, v in count.items():
            heapq.heappush(pq, (v, k))
            if len(pq) > k:
                heapq.heappop(pq)

        result = []
        for _, num in pq:
            result.append(num)
        return result

    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        """
            https://leetcode.com/problems/top-k-frequent-elements/
            Time Complexity - O(nlogn)
            Space Complexity - O(n)
        """
        count = defaultdict(list)
        for num in nums:
            count[num].append(num)

        pq = []
        for v in count.values():
            heapq.heappush(pq, (-len(v), v))
        result = []
        for i in range(k):
            result.append(heapq.heappop(pq)[1][0])
        return result
