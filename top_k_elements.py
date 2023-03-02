# Time Complexity: O(n)
# Space Complexity: O(n)


from collections import Counter


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        x = Counter(nums)
        if len(nums) == 1 and k == 1:
            return nums
        out = [[] for i in range(len(nums)+1)]
        for key, val in x.items():
            if not out[val]:
                out[val] = []
            out[val].append(key)
        idx = len(out)
        res = []
        while k >= 1:
            idx -= 1
            if not out[idx]:
                continue
            for val in out[idx]:
                res.append(val)
                k -= 1

        return res
