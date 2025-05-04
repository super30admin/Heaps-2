import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Time Complexity: O(N + Mlogk), where N is all numbers in nums, M is unique numbers and k is the limit or heap height
 * Space Complexity: O(N + K)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * 1. Collect frequencies of all unique numbers
 * 2. Add based on frequency to a min heap
 * 3. Poll if the heap size goes beyond k
 * 4. Return the result
 */

public class TopKFrequentElement {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for (int key: map.keySet()) {
            int[] entry = new int[]{key, map.get(key)};
            pq.add(entry);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k; i > 0; i--) {
            result[i - 1] = pq.poll()[0];
        }

        return result;
    }
    public static void main(String[] args) {
        // Your code here
    }
}