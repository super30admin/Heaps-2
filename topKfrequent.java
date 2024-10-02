
class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }//for

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            return a.getValue() - b.getValue();
        });

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        int j = 0;

        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            res[j] = entry.getKey();
            j++;
        }

        return res;

    }//method
}
