import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //o(nlogk) time and o(n) space
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            if(map.containsKey(nums[i])){
                int val = map.get(nums[i]);
                map.put(nums[i], val + 1);
            }
            else{
                map.put(nums[i], 1);

            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for(int key: map.keySet()){
            pq.add(new int[] {key, map.get(key)});
            if(pq.size() > k){
                pq.poll();
            }
        }
        for(int i = k-1; i >=0; i--){
            int [] curr = pq.poll();
            result[i] = curr[0];
        }
     return result;   
    }
}