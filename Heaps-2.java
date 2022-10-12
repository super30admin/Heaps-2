class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == k) return nums;
        
        Map<Integer,Integer> cmap = new HashMap<>();
        
        // it stores frequency of each element
        for(int i: nums)
            cmap.put(i, cmap.getOrDefault(i,0)+1);
        
        Queue<Integer> que = new PriorityQueue<>(k, (a,b) -> cmap.get(a)-cmap.get(b));

        for(int i: cmap.keySet()){
            que.add(i);
            if(que.size()>k)
                que.poll();
        }
        
        return que.stream().mapToInt(Integer::valueOf).toArray();
    }
}

TC:O(N)

