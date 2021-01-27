# BUCKET SORT APPROACH
# TIME COMPLEXITY: O(n)
# SPACE COMPLEXITY: O(n)

from collections import Counter


class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        freq_map = Counter(nums)
        buckets = [[] for _ in range(len(nums)+1)]

        for num, freq in freq_map.items():
            buckets[freq].append(num)

        result = []
        for i in reversed(range(len(buckets))):
            bucket = buckets[i]
            if bucket and len(result) < k:
                for ele in bucket:
                    result.append(ele)

        return result
