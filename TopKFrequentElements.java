// space complexity: O(n)
// time complexity: O(nlogk)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // first lets construct a map with frequency
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        // lets define min heap priority queue based on key
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for(int num: map.keySet()) {
            pq.add(num);

            if(pq.size() > k) {
                pq.poll();
            }
        } // end of for loop

        int[] result = new int[k];
        int counter = 0;

        while(!pq.isEmpty()) {
            result[counter++] = pq.poll();
        }
        return result;
    }
}