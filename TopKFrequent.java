// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(nums == null || nums.length == 0) return new int[] {};
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List[] liArray = new List[nums.length + 1];
        
        for(int element : map.keySet()) {
            int index = map.get(element);
            if(liArray[index] == null) {
                liArray[index] = new ArrayList<>();
            }
            liArray[index].add(element);
        }
        
        for(int i = liArray.length - 1; i >= 0 ; i--) {
            
            if(liArray[i] == null) continue;
            
            List<Integer> li = liArray[i];
            
            for(int num : li) {
                k--;
                if(k < 0) break;
                result[k] = num;
            }
        }
        
        return result;
    }
}