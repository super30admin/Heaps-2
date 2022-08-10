//Time: O(N) | Space: O(N+K)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            int freq = map.getOrDefault(nums[i], 0)+1;
            map.put(nums[i],freq);
            max = Math.max(max, freq);
            min = Math.min(min, freq);
        }

        Map<Integer, List<Integer>> freqMap = new HashMap<>();
        for(int key: map.keySet()) {
            int freq = map.get(key);
            if(!freqMap.containsKey(freq)){
                freqMap.put(freq, new ArrayList<>());
            }
            freqMap.get(freq).add(key);
        }
        int[] result = new int[k];
        int count = 0;
        for(int i=max;i>=min && count < k;i--){
            if(freqMap.containsKey(i)) {
                List<Integer> li = freqMap.get(i);
                for(int item: li) {
                    result[count] = item;
                    count++;
                }
            }
        }
        return result;
    }
}
//Heap Soln
//Time: O(Nlogk) | Space: O(N)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for(int ele: map.keySet()) {
            pq.add(ele);
            if(pq.size() > k)
                pq.poll();
        }

        int[] result = new int[k];
        for(int i=0;i<k;i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}