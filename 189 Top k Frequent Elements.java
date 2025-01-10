// Time Complexity : O(nlogk)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    //aesha
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums)
        {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return map.get(a) - map.get(b);
        });

        for(int key: map.keySet())
        {
            pq.add(key);
            if(pq.size() > k) 
                pq.poll();
        }

        int[] result = new int[k];
        int idx =0;
        while(!pq.isEmpty())
        {
            result[idx] = pq.poll();
            idx++;
        }
        return result;
    }
}