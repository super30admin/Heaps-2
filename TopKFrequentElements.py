#Time Complexity - O(N)
#Space Complexity - O(N)
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        dict= {}
        n=len(nums)
        arr=[[] for _ in range((n+1))]
        for i in nums:
            if i in dict:
                dict[i]+=1
            else:
                dict[i]=1
        for key,values in dict.items():
            arr[values].append(key)
        result=[]
        for bucket in range(len(arr)-1,-1,-1):
            for num in arr[bucket]:
                if(len(result)==k):
                    return result
                result.append(num)
        return result
     
     
   # HEAP
   #Time Complexity - O(NLOGK)
   # Space Complexity - O(N) hashmap O(K) heap
   class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        dict= {}
        result=[]
        for i in nums:
            if i in dict:
                dict[i]+=1
            else:
                dict[i]=1

        heap=[()]
        heap =[(-val,key) for key,val in dict.items()]
        heapq.heapify(heap)
        for i in range(k):
            result.append(heapq.heappop(heap)[1])
        return result
        
