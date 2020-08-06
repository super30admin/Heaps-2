//time complexity O(n)
//space complexity O(n) size of hashmap. priority queue and result array can be neglected because k is constant and negligible

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        for(int num: nums){//O(n)
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            return map.get(a) - map.get(b);
        });
        for(int key: map.keySet()){//O(n)
            pq.add(key);
            if(pq.size() > k){
                pq.poll();
            }
        }
        for(int i = 0; i < k; i++){
            result[result.length -1 - i] = pq.poll();
        }
        return result;
    }
}
