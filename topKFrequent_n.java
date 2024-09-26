// Time Complexity : O(n) where n is the length of the array nums
// Space Complexity : O(n) where n is the length of the array nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class topKFrequent_n {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (buckets[val] == null) {
                buckets[val] = new ArrayList<>();
            }
            buckets[val].add(key);
        }
        for (int i = buckets.length - 1; i >= 0 && ans.size() < k; i--) {
            if (buckets[i] != null) {
                for (int j = 0; j < buckets[i].size() && ans.size() < k; j++) {
                    ans.add(buckets[i].get(j));
                }
            }
        }
        return ans;
    }
}