#Time complexity : O(n)
#Space complexity: O(n)
#Works on leetcode : yes
#Approach : We just keep track of the frequency of each number in the nums. Then we iterate through frequency from len(nums) to 0
#and add the first k frequent elements to result and return it. 

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = collections.defaultdict(list)
        for key, cnt in collections.Counter(nums).items():
            count[cnt].append(key)
        res = []
        for frq in reversed(range(len(nums)+1)):
            res.extend(count[frq])
            if len(res) >= k : 
                break
        return res[:k]