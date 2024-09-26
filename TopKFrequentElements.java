// Time Complexity: O(nlogk), where n is for the hashmap and log k ifor the PriorityQueue
// Space Complexity: O(n)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
        	map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));


        for(int e: map.keySet()) {
        	minHeap.add(e);

        	if(minHeap.size() > k) {
        		minHeap.poll();
        	}
        }

        int[] top_k = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
        	top_k[index++] = minHeap.poll();
        }

        return top_k;
    }
}