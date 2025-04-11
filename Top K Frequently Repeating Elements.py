#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        result = []
        count = defaultdict()
        freq = [[] for i in range(0,len(nums)+1)]
        for n in nums:
            count[n] = 1 + count.get(n,0)
        for n,c in count.items():
            freq[c].append(n)
        for i in range(len(freq)-1,0,-1):
            for n in freq[i]:
                result.append(n)
                if(len(result)==k):
                    return result