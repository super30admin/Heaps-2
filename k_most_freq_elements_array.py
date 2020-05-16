// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
we used min heap and dictionary to solve this problem.
we made sure that min heap contains only k elements in the heap i.e the top most k frequent elements in the input.


# Time complexity --> o(nlogk) n--> number of elements
# space complexity --> o(n)
import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        if nums==None or len(nums)==0:
            return []
        ele_freq=dict()
        h=[]
        out=[]
        #created a dictionary containing key as the number in the array and value as the frequency
        for i in nums:
            if i not in ele_freq:
                ele_freq[i]=1
            else:
                ele_freq[i]=ele_freq[i]+1
        #we trying to maintain a min heap of length K so that it contains the top k most frequent elements in the array
        for key,value in ele_freq.items():
            #If the length of the heap is less than k we add elements into the heap.we insert by taking the freq as the value to be considered for priority in the heap and key which is the number in the array to be stored in the heap.
            if len(h)<k:
                heapq.heappush(h,(value,key))
            else:
            #If the heap is full (i.e the heap length is k then we check the min prioritised element in the heap and check the next value in the dictionary and if the dictionary value has more priority compared to min element in the heap .we pop the element from the heap and then insert the dictionary value into the heap.
            
            #for instance take a heap which has heap=[[1:3],[3:1]] and k=2 ([frequency of the input element:input element] --> format present in the heap).then when [2:2] comes 2 has more priority compared to 1 which is the min element in the heap.so we pop out the min element from the heap and then insert [2:2] into the heap as we need heap to contain the k most frequent element in the array.
                val_at_min=h[0]
                if val_at_min[0]<value:
                    heapq.heappop(h)
                    heapq.heappush(h,(value,key))
        #pop all the elements from the heap into the out array.
        while len(h)>0:
            val=heapq.heappop(h)
            out.append(val[1])
        return (out)