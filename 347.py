class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        if len(nums) == 0 :
            return []
        frequency_map = Counter(nums)
        max_freq = max(frequency_map.values()) 
        buckets = [[] for _ in range(max_freq + 1)]
        for num, freq in frequency_map.items():
            buckets[freq].append(num)
        result = []
        for i in range(max_freq, -1, -1):
            for num in buckets[i]:
                result.append(num)
                if len(result) == k:
                    return result


        # TC : O(n)
        # SC = O(n)