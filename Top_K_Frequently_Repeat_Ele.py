# Approach:
# 1. Count the frequency of each element in the list using Counter.
# 2. Use a min-heap to store the top k frequent elements.
# 3. Push elements into the heap based on their frequency and pop the least frequent element if the heap exceeds size k.
# 4. Extract the top k elements from the heap.

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # Step 1: Count the frequency of each number
        freq_map = Counter(nums)  # Dictionary that maps elements to their frequencies

        # Step 2: Use a min-heap to store k most frequent elements
        min_heap = []

        # Step 3: Iterate through the frequency dictionary
        for num, freq in freq_map.items():
            heapq.heappush(min_heap, (freq, num))  # Push (frequency, number) into min-heap
            if len(min_heap) > k:
                heapq.heappop(min_heap)  # Remove the least frequent element

        # Step 4: Extract the numbers from the heap and return them
        return [num for freq, num in min_heap]

# Time Complexity: O(N log K), where N is the number of elements in nums.
# - Building the frequency dictionary takes O(N).
# - Pushing and popping from the heap takes O(log K), done N times, so O(N log K).

# Space Complexity: O(N), used for storing the frequency map and the heap.