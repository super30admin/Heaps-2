//TC: O(n log k)
//SC: O(n)
//Rnning on leetcode: yes
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[] {};
        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return map.get(a) - map.get(b);
        });
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) +1);
        }
        for(int key : map.keySet()) {
            pq.add(key);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int index = 0;
        while(!pq.isEmpty()) {
            result[index] = pq.poll();
            index++;
        }
        return result;
    }
}
