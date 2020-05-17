'''
Time Complexity: O(nlogk)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation: Use Hashmap to count the frequency for each number then use a heap to keep only the top k frequent numbers
in the heap (if length of heap > k => pop )
'''
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = {}
        for num in nums:
            if num not in freq:
                freq[num] = 1
            else:
                freq[num] += 1

        print(freq)

        # If you use sorting O(n logn)
        # p = [x[0] for x in sorted(freq.items(), reverse=True, key = lambda item: item[1])] return p[:k]

        # shortcut for python insert 3 elements and get largest one
        # return heapq.nlargest(k, freq.keys(),key=freq.get)

        class Wrapper:
            def __init__(self, val):
                self.val = val

            def __lt__(self, other):
                return freq[self.val] < freq[other.val]

        heap = []
        for elem in freq.keys():
            heapq.heappush(heap, Wrapper(elem))
            if len(heap) > k:
                heappop(heap)

        res = []
        while len(heap) != 0:
            res.append(heapq.heappop(heap).val)
        # no need to sort as you can return answer in any order
        return res