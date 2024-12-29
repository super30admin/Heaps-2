#Approach
#find the frequencies and reverse freqencies and iterate over min to max frequency and add to the result



#Complexities
#Time : O(n)
#Space: O(n)




from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freqMap = dict()
        minfreq = len(nums)
        maxfreq = 0
        for num in nums:
            freqMap[num] = freqMap.get(num, 0) + 1
            minfreq = min(minfreq, freqMap[num])
            maxfreq = max(maxfreq, freqMap[num])

        reverseFreqMap = dict()
        for keys in freqMap:
            if freqMap[keys] not in reverseFreqMap:
                reverseFreqMap[freqMap[keys]] = []
            reverseFreqMap[freqMap[keys]].append(keys)
        result = []
        for i in range(maxfreq, minfreq - 1, -1):
            if i in reverseFreqMap:
                for ele in reverseFreqMap[i]:
                    k -= 1
                    if k < 0:
                        break
                    else:
                        result.append(ele)
        return result