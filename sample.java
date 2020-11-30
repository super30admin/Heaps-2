// Top K frequent elements
// Time Complexity: O(log n)
// Space Complexity: O(n + m) space for map and priorityqueue 

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // creating map of number to its frequency
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // creating max heap based on number frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (int key : map.keySet()) {
            pq.offer(key);
        }
        // getting top k frequent elements
        int[] result = new int[k];
        for (int i=0; i<k; i++) {
            result[i] = pq.poll();
        }
        
        return result;
    }
}
