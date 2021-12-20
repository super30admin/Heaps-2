
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        """
        There are solution, using quickselect with O(n) complexity in average, but I think they are overcomplicated: actually, there is O(n) solution, using bucket sort. The idea, is that frequency of any element can not be more than n. So, the plan is the following:

Create list of empty lists for bucktes: for frequencies 1, 2, ..., n.
Use Counter to count frequencies of elements in nums
Iterate over our Counter and add elements to corresponding buckets.
buckets is list of lists now, create one big list out of it.
Finally, take the k last elements from this list, these elements will be top K frequent elements.
Complexity: time complexity is O(n), because we first iterate over nums once and create buckets, then we flatten list of lists with total number of elements O(n) and finally we return last k elements. Space complexity is also O(n).

        """

        n = len(nums)
        buckets = [[] for _ in range(n + 1)]
        hashmap = {}
        for num in nums:
            if num in hashmap:
                hashmap[num] += 1
            else:
                hashmap[num] = 1
        for num, freq in hashmap.items():
            buckets[freq].append(num)

        result = []
        ##traverse from right to left of bucket:
        for i in range(n, -1, -1):
            bucket = buckets[i]
            if bucket:
                for num in bucket:
                    result.append(num)
                    if len(result) == k:
                        return result[:k]
        return []

        ###finally take the first k
        # return result[:k]

        # print(buckets)
