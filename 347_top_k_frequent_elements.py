"""
## Problem 347: Top K Frequent Elements

## Author: Neha Doiphode
## Date:   11-20-2022

## Description
    Given an integer array nums and an integer k, return the k most frequent elements.
    You may return the answer in any order.

## Examples:
    Example 1:
        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]

    Example 2:
        Input: nums = [1], k = 1
        Output: [1]

## Constraints:
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    k is in the range [1, the number of unique elements in the array].
    It is guaranteed that the answer is unique.

## Time complexity: Please refer to the doc-strings of different approaches used below.

## Space complexity: Please refer to the doc-strings of different approaches used below.

"""
from typing import List, Optional
from heapq import heappush, heappop
from collections import defaultdict, Counter


def get_input():
    print("Enter the list of integers(with spaces): ", end = "")
    nums = input()
    nums = [int(num) for num in nums.split()]

    print("Enter integer k(most frequent elements in the list): ", end = "")
    k = int(input())

    print()
    return nums, k

class Solution:
    def topKFrequent_using_counter_module(self, nums: List[int], k: int) -> List[int]:
        """
        Time complexity: O(n log k + k), where n is number of elements in nums.
                                   O(n log k) to form the counter dictionary with most common k elements.
                                   Internally, most_common function uses heap sort and heapq's nlargest functionality.
                                   Hence, the time complexity is O(n log k).

                                   O(k) to loop over counter dictionary k times to collect requried keys.
        Space complexity:
        """
        l = Counter(nums).most_common(k)
        result = [key for key, value in l]
        return result

    def topKFrequent_using_dictionary(self, nums: List[int], k: int) -> List[int]:
        """
        Time complexity: O(k * N), where N is number of distinct elements in the list.
                         O(n), to form the counter dictionary, where n is number of elements in nums.
                         O(k * N), to find k, max frequency elements
                                   O(N) to perform max operation. And it is performed k times.
                                   Out of the two terms, we choose the max term to determine asymptotic time compelxity.
        Space complexity:
        """
        d = defaultdict(lambda: 0)
        result = []

        for num in nums:
            d[num] += 1

        while k:
            key = max(d, key = d.get)
            result.append(key)
            d.pop(key)
            k -= 1
        return result

    def topKFrequent_using_heap(self, nums: List[int], k: int) -> List[int]:
        """
        Time complexity: O(nlog k), where n is the number of elements in nums and
                                    heap is always maintained to have k elements.
        Space complexity: O(n), to create the counter dictionary.
        """
        c = Counter(nums)
        heap = []

        for key, value in c.items():
            heappush(heap, (value, key))
            if len(heap) > k:
                heappop(heap)

        result = [key for value, key in heap]

        return result

    def topKFrequent_using_lists(self, nums: List[int], k: int) -> List[int]:
        """
        Time complexity: O(n), where n is the number of elements in nums.
                         O(n) - To form counter dictionary.
                         O(n) - To form the mapper list which maps elements with same counts to indices in a list.
                         O(k) - To re-collect k elements from mapper and add them to the final result.
                         So the overall time complexity is O(n).

        Space complexity: O(n), to create the counter dictionary, mapper list.
        """
        c = Counter(nums)
        max_count = c[max(c, key = c.get)]
        #print(c)
        mapper = [[] for _ in range(max_count + 1)]

        for key, value in c.items():
            mapper[value].append(key)

        result = []

        #print(mapper)
        counter = k
        most_frequent = len(mapper) - 1
        while counter > 0:
            if len(mapper[most_frequent]) > 0:
                result.extend(mapper[most_frequent])
                counter -= 1

            if len(result) > k:
                break

            most_frequent -= 1

        while len(result) > k:
            result.pop()

        return result


# Driver code
solution = Solution()
nums, k = get_input()
print(f"Input: List of integers: {nums}")
print(f"Input: k: {k}")
print(f"Output: Approach 1: Using counter module: {k} most frequent elements in the list are: {solution.topKFrequent_using_counter_module(nums, k)}")
print(f"Output: Approach 2: Using dictionary: {k} most frequent elements in the list are: {solution.topKFrequent_using_dictionary(nums, k)}")
print(f"Output: Approach 3: Using min heap: {k} most frequent elements in the list are: {solution.topKFrequent_using_heap(nums, k)}")
print(f"Output: Approach 4: Using lists: {k} most frequent elements in the list are: {solution.topKFrequent_using_lists(nums, k)}")
