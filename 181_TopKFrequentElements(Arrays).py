class Solution:
    '''
    Accepted on leetcode(347)
    time - O(N)
    space - O(N)
    '''

    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        # creating frequency hashmap and populate them
        hashmap = {}
        for num in nums:
            if num not in hashmap:
                hashmap[num] = 1
            else:
                hashmap[num] += 1

        # creating frequency buckets as list and populate them with nums.
        bucket = [None for i in range(len(nums) + 1)]

        for key in hashmap.keys():
            freq = hashmap[key]

            if bucket[freq] is None:
                bucket[freq] = []
            bucket[freq].append(key)

        # create output list
        retList = []

        for i in range(len(bucket) - 1, 0, -1):
            if len(retList) < k:
                if bucket[i] != None:
                    retList += bucket[i]
            else:
                break;

        # if retList size exceeds k , then return k starting elements.
        if len(retList) <= k:
            return retList
        return retList[:k]