//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counter = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
        }
       
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> counter.get(b) - counter.get(a));
        int[] result = new int[k];
        
        for(int num : counter.keySet()) {
            q.add(num);
        }
        
        for(int i = 0; i < k; i++) {
            result[i] = q.poll();
        }

        return result;
    }
}