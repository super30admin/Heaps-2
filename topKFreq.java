// TC: O(n)
// SC: O(n)

import java.util.*;

public class topKFreq {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        // getting count of each elements
        for(int i=0; i<nums.length; i++){
            int x = map.getOrDefault(nums[i], 0);
            map.put(nums[i], x+1);
        }
        //sorting the map values and adding it to PQ (Max heap)
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        for (int n: map.keySet()) {
          heap.add(n);
          if (heap.size() > k) 
              heap.poll();    
        }
        //getting top k elements
        int[] arr = new int[k];
        for(int i=0; i<k; i++){
            arr[i] = heap.poll();
         }
        return arr;
    }
}
