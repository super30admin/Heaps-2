// Approach : Instead of Using Priority Queue we can still create a freq map and then create another map (freqToNumMap) with reverse mapping - frequency : [list of nums] and perform bucket sort by maintaining max to min in the map.
// Finally Iterate through the freqToNumMap and extract the result;
// Time : O(n) // O(max to min)
// Space : O(n) # HashMap Size
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> map  = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        HashMap<Integer , List<Integer>> freqToNumMap  = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = 0;

        // Bucket Sort
        for(int num:map.keySet()){
            int freq = map.get(num);
            freqToNumMap.putIfAbsent(freq, new ArrayList<>());
            freqToNumMap.get(freq).add(num);
            min = Math.min(min , freq);
            max = Math.max(max,freq);
        }

        int[] result = new int[k];
        int idx = 0;

        // Iterate on freqToNumMap from max to min but stop it as soon as idx reaches k
        for(int i =max ;i>=min && idx<k;i--){
            if(!freqToNumMap.containsKey(i)) continue;
            List<Integer> curList = freqToNumMap.get(i);
            for(int j=0;j<curList.size()&&idx<k;j++){
                result[idx]= curList.get(j);
                idx++;
            }
        }
        return result;
    }
}

// Approach : Using Priority Queue - Min Heap.. Maintain a freqMap and then using min Heap () of size k we can extract top k freq elements
// Time : O(nlogk) // logk operations for all n items in the map
// Space : O(n) # HashMap Size
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Priority Queue operated as min heap based on the frequencies - smaller freq
        // will always try to be on the top
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int num : map.keySet()) {
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
            // heapify happens when the incoming num freq is smaller than element on the top of the heap
        }

        int[] result = new int[k];
        int idx = 0;

        while(!pq.isEmpty()){
            result[idx] = pq.poll();
            idx++;
        }
        return result;
    }
}