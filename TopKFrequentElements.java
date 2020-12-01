// Time Complexity : O(nlogk)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Using MaxHeap
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2)->map.get(n1)-map.get(n2));
        for(int n : map.keySet()){
            pq.add(n);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        int res[] = new int[k];
        for(int i=k-1; i>=0; i--){
            res[i] = pq.poll();
        }
        return res;
        
    }
}