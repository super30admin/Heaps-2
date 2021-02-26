// Time, Space - O(NlgK), O(N)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[] {};
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int ele = entry.getKey();
            int freq = entry.getValue();
            
            q.add(new int[]{ ele, freq });
            
            if(q.size() > k) {
                q.poll();
            }
        }
        int[] result = new int[q.size()];
        int i=0;
        while(!q.isEmpty()) {
            result[i] = q.poll()[0];
            i++;
        }
        
        return result;
        
    }
}
