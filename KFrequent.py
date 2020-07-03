'''
Solution:
1.  Firstly, calculate number-count HashMap and then convert to custom class pairs while pushing into Heap
2.  For each number in the Map, create the pair class object, insert the object in min-heap, if size exceeds
    k => remove the minimum frequent object.
3.  Now, put all top k frequent elements in correct locations (in reverse directions as it is a min heap) and return.

Time Complexity:    O(N.logK)
Space Complexity:   O(N) for HashMap + O(K) for Heap => O(N)

--- Passed all testcases successfully on leetcode.
'''


from heapq import heappush as insert
from heapq import heappop as remove


class NumberFrequencyPair:

    #   Create Custom Class for number-frequency pair
    def __init__(self, number, frequency):
        self.number = number
        self.frequency = frequency

    def getNumber(self):
        return self.number

    def __lt__(self, other):
        if (self.frequency < other.frequency):
            return True
        return False

    def __gt__(self, other):
        if (self.frequency > other.frequency):
            return True
        return False

    def __eq__(self, other):
        return self.frequency == other.frequency


class KfrequentHeap :

    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        #   edge case checks
        if (nums == None or len(nums) == 0):
            return []

        #   initializations
        finalResult = [0 for i in range(k)]

        frequencyMap = {}
        minHeap = []

        #   calculate number-count HashMap and then convert to custom class pairs while pushing into Heap
        for num in nums:

            if num not in frequencyMap:
                frequencyMap[num] = 1
            else:
                frequencyMap[num] += 1

        #   for each number in the Map
        for number in frequencyMap:

            #   create the pair class object
            currentPair = NumberFrequencyPair(number, frequencyMap[number])

            #   insert the element
            insert(minHeap, currentPair)

            #   if size exceeds k => remove the minimum frequent element
            if len(minHeap) > k:
                remove(minHeap)

        #   now, put all top k frequent elements in correct locations (in reverse directions as it is a min heap)
        for i in range(k - 1, -1, -1):
            poppedPair = remove(minHeap)
            finalResult[i] = poppedPair.getNumber()

        #   return the final result
        return finalResult