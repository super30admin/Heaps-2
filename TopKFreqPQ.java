class Solution {
    // tc-nlogk sc-o(n)
     public int[] topKFrequent(int[] nums, int k) {
         HashMap<Integer,Integer> map = new HashMap<>();
         int[] result = new int[k];
         for(int i=0;i<nums.length;i++)
         {
             map.put(nums[i], map.getOrDefault(nums[i],0)+1);
         }
         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->
         map.get(a) - map.get(b)
         );
         for(int key: map.keySet())
         {
             pq.add(key);
             if(pq.size() > k) pq.poll();
         }
         int i=0;
         while(!pq.isEmpty()){
         result[i] = pq.poll();
         i++;
         }
         return result;
     }
 }