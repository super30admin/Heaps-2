
//TC - O(N logK)
//SC - O(N + K)
import java.util.*;

class Solution {
	public int[] topKFrequent(int[] nums, int k) {
		int[] result = new int[k];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			return map.get(a) - map.get(b);
		});
		for (int key : map.keySet()) {
			pq.add(key);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = pq.poll();
		}
		return result;
	}
}