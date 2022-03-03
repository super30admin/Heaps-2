# TC: O(n log k)
# SC: O(n)

from queue import PriorityQueue


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        if nums is None or len(nums) == 0:
            return []

        hashmap = {}

        for num in nums:
            hashmap[num] = hashmap.get(num, 0) + 1

        pq = PriorityQueue()
        i = 0

        for key in hashmap:
            pq.put((hashmap[key], i, key))

            if len(pq.queue) > k:
                pq.get()

            i += 1

        result = [None] * k
        for j in range(k - 1, -1, -1):
            _, i, val = pq.get()
            result[j] = val

        return result


#
# TC: O(n)
# SC: O(max(n+ maxCount))

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        if nums is None or len(nums) == 0:
            return []

        hashmap = {}

        _max = 0
        for num in nums:
            hashmap[num] = hashmap.get(num, 0) + 1
            _max = max(_max, hashmap[num])

        arr = [None] * (_max + 1)
        for key in hashmap:
            if arr[hashmap[key]] is None:
                arr[hashmap[key]] = []
            arr[hashmap[key]].append(key)

        result = [None] * k

        for j in range(len(arr) - 1, -1, -1):
            if arr[j] is not None:
                li = arr[j]
                for elem in li:
                    if k > 0:
                        result[len(result) - k] = elem
                        k -= 1

        return result




