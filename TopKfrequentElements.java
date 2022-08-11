// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class TopKfrequentElements {

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();

            for(int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            List<Integer>[] freq = new ArrayList[nums.length+1];

            for(Integer key: map.keySet()) {
                int index = map.get(key);
                if(freq[index] == null)
                    freq[index]  =  new ArrayList<>();
                freq[index].add(key);
            }
            List<Integer> result = new ArrayList<>();
            for(int i=freq.length-1; i>=0; i--){
                if(freq[i]!= null)
                    result.addAll(freq[i]);
                if(result.size() == k)
                    return result.stream().mapToInt(ele -> ele).toArray();
            }
            return new int[0];
        }
    }
}
