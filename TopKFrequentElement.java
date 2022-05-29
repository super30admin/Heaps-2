// Time Complexity : O(n log k) where n is the length of array and k is the freq value
// Space Complexity : O(n+k) k for heap and  n for map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create map and store the frequencies of each element
// Use proiority queue with comparator to order according to freq
// Remove the min elements which are in excess of k
// Add the remaining elements in array and return
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     Map<Integer, Integer> hm = new HashMap<>();
        for(int x: nums){
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            pq.add(entry);
            if(pq.size() > k)
                pq.remove();
        }
        int[] result = new int[k];
        while(!pq.isEmpty()){
            result[k-1] = pq.poll().getKey();
            k--;
        }
        return result;
    }
}