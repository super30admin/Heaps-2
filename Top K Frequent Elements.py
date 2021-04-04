#time: O(nlogn) where n is the no of unique elements
#space:O(n)
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count=Counter(nums)
        count=sorted(count, key= lambda x : (count[x]),reverse=True)
        result=[]
        for i in count:
            if(k<=0):
                break
            result.append(i)
            k-=1
        return result