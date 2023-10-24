// Time Complexity : O(nlogk)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length){
            return nums;
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1]-b[1]));

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            pq.add(new int[]{entry.getKey(), entry.getValue()});
            if(pq.size() > k){
                pq.remove();
            }
        }

        int[] result = new int[k];
        int size = pq.size();

        for(int i=0; i<size; i++){
            result[i] = pq.remove()[0];
        }

        return result;
    }
}