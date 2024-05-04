
//TimeComplexity: O(nlogk)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<nums.length;i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i])+1);
        }
        //min heap
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->{
            return map.get(a) - map.get(b);
        });
        for(int key:map.keySet()) {
            pq.add(key);
            if(pq.size() > k) {
                pq.poll();
            }
        }
            int []result = new int[k];
            int index=0;
            while(!pq.isEmpty()) {

                result[index] = pq.poll();
                index++;
            }
        
        return result;
    }
}