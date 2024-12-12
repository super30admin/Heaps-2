//Time Complexity: O(N+kLog(D)) where D is the number of distinct elements
//Space Complexity: O(D)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        //populate the map with the frequency
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i =0; i<n;i++)
        {
            mp.put(nums[i], mp.getOrDefault(nums[i],0)+1);
        }
        //max Heap
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->
        a.getValue().equals(b.getValue())?
        Integer.compare(b.getKey(),a.getKey()): Integer.compare(b.getValue(),a.getValue()));
           
        int[] result = new int[k];
        for(Map.Entry<Integer,Integer> entry: mp.entrySet())
        {
            pq.offer(entry);
        }
        for(int i = 0; i<k;i++)
        {
            result[i] = pq.poll().getKey();
        }
        return result;
    }
}
