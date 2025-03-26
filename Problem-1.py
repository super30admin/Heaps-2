'''
    Time Complexity: O(n)
    Space Complexity: O(n)
'''
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hashmap = {}

        for num in nums:
            if num not in hashmap:
                hashmap[num] = 1
            else:
                hashmap[num] += 1

        freqBuckets = [None for _ in range(len(nums))]

        for key in hashmap.keys():
            freq = hashmap[key]

            if freqBuckets[freq-1] == None:
                freqBuckets[freq-1] = [key]
            else:
                freqBuckets[freq-1].append(key)

        result = []
        for i in range(len(nums)-1, -1, -1):
            if freqBuckets[i]:
                for num in freqBuckets[i]:
                    result.append(num)

                if len(result) == k:
                    break

        return result
            