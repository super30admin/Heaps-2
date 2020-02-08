TC: O(n)
SC: O(1)

Runtime: 9 ms, faster than 97.49% of Java online submissions for Top K Frequent Elements.
Memory Usage: 43.1 MB, less than 5.17% of Java online submissions for Top K Frequent Elements.


class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        List<Integer> [] bucket = new List[nums.length+1];
        HashMap<Integer, Integer> frequency = new HashMap<>();
        
        for(int num: nums){
            frequency.put(num, frequency.getOrDefault(num,0)+1);
        }
        // for creating buckets
        for(int key: frequency.keySet()){
            int freq = frequency.get(key);
            
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        
        List<Integer> retList = new ArrayList<>();
        
        for(int x=bucket.length-1; x>=0 && retList.size() <k;x--){
            if(bucket[x] != null){
                retList.addAll(bucket[x]);
            }
            
        }
        if(retList.size() <= k) return retList;
        
        return retList.subList(0,k);
    }
}
