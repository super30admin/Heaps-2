// Time Complexity : O(nlogk) // n elements k height
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        if(nums == null || nums.length == 0){
            return new int[] {};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1 );
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[1]- b[1];
        }); 

        for(int key:map.keySet()){
            int [] freq = new int[] {key, map.get(key)}; 
            pq.add(freq);
            if(pq.size() > k){
                pq.poll();
            }
        }   
        int res[] = new int[k];

        while(!pq.isEmpty()){
            int temp[] = pq.poll();
            res[k-1] = temp[0];
            k--;
        }
        return res;
    }
}