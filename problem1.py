#Top K Frequently Repeating Elements


# // Time Complexity : O(N)
# // Space Complexity :O(D) D-distinct numbers
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hashmap={}
        res=[]
        for i in nums:
            hashmap[i]=hashmap.get(i, 0)+1                  #add the frequency of numbers to a hashmap
        arr=[[] for i in range(len(nums)+1)]
        for i in hashmap:
            arr[hashmap[i]].append(i)                       #insert the numbers in their frequency index
        
        for i in range(len(nums), 0, -1):                   #start from the end of the list and keep adding the elements until k becomes 0
            for j in arr[i]:
                res.append(j)
                if (k==len(res)):
                    return res
                    
        return 0
                    
            
        