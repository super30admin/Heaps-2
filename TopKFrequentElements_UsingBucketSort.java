// Time Complexity : O(n) --> where n is the length of input nums array and k is the given input k
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (347): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int result [] = new int[k];
        // edge case
        if (nums == null || nums.length == 0) return new int[k];
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List buckets [] = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (buckets[freq] == null) buckets[freq] = new ArrayList<>();
            buckets[freq].add(key);
        }
        
        for (int i = buckets.length - 1; i >= 0 && k > 0; i--) {
            List<Integer> bucket = buckets[i];
            if (bucket != null) {
                for (int num : bucket) {
                    if (k > 0) result[result.length - k] = num;
                    else break;
                    k--;
                }
            }
        }
            
        return result;
    }
}