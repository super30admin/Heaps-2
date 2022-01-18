// Time Complexity: O(n log k)
// Space Complexity: O(n + k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int key : map.keySet()) {
            pq.add(new int[] {key, map.get(key)});
            if(pq.size() > k) {
                pq.poll();
            }
        }
        for(int i = k - 1; i >= 0; i--) {
            int[] curr = pq.poll();
            result[i] = curr[0];
        }
        return result;
    }
}