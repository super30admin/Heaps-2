// Time Complexity : O(n log(k)) --> where n is the length of input nums array and k is the given input k
// Space Complexity : O(n + k)
// Did this code successfully run on Leetcode (347): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int result [] = new int[k];
        // edge case
        if (nums == null || nums.length == 0) return result;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return map.get(a) - map.get(b);
        });
        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) pq.poll();
        }
        
        for (int i = result.length - 1; i >=0; i--) {
            result[i] = pq.poll();
        }
        return result;
    }
}