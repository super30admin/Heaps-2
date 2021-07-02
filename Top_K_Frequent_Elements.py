from collections import Counter
class Solution:
    

    
    #heap
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        if not nums:
            return []
        if k == len(nums):
            return nums
        
        counter = Counter(nums)
        
        heap = []
        
        for key,value in counter.items():
            if len(heap) < k:
                heappush(heap,(value,key))                
            else:
                heappushpop(heap,(value,key))
                
        return [item[1] for item in heap]
        

    
    def topKFrequent_list(self, nums: List[int], k: int) -> List[int]:
        if not nums:
            return []
        
        freq_list = [None] * (len(nums)+1)
        if k == len(nums):
            return nums
        counter = Counter(nums)
        for num,freq in counter.items():
            if not freq_list[freq]:
                freq_list[freq] = []
            
            freq_list[freq].append(num)
        
        print(freq_list)
        print(counter)
        result = []
        for i in range(len(freq_list)-1,-1,-1):
            #print(len(freq_list), i)
            if k == 0:
                return result            
            if freq_list[i]: 
                for num in freq_list[i]:
                    result.append(num)
                    k -=1
        
        
