'''
Time Complexity: 0(nlogm)
                --- where m in the maxCount/occurance
Space Complexity: 0(m)
Run on LeetCode: Yes
'''
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        # maintain a dictionary
        numsDict = {}
        
        # maintain maxCount
        maxCount = 0
        
        # iterate the nums
        for num in nums:
            if num not in numsDict:
                numsDict[num] = 1
            else:
                numsDict[num] += 1
            maxCount = max(maxCount,numsDict[num])
        
        # maintain bucketList of maxCount
        bucketList = [None]*(maxCount+1)
        
        # iterate numsDict and add the result into the bucketList
        for key in numsDict: 
            # get the index i.e. count
            count = numsDict[key]
            
            if bucketList[count] == None:
                bucketList[count] = [key]
            else:
                bucketList[count].append(key)
        
        # print('BucketList is:\t',bucketList)
        
        # now add the result to the resultList
        result = []
        for i in range(len(bucketList)-1,-1,-1):
            # print('i:\t',i)
            # base-case
            if k == 0:
                break
                
            pair = bucketList[i]
            
            if pair == None:
                continue
            
            for key in pair:
                # base-case
                if k == 0:
                    break
                else:
                    result.append(key)
                    k -= 1
        
        # print the result
        # print(result)
        return result