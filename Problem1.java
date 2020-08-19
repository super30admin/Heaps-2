// Time Complexity - O(n) where n is the number of elements in nums array
// Space Complexity - O(n)


class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length ==0) return new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        List<Integer>[] bucket = new List[nums.length+1];
       
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1); 
        }
        for(int num : map.keySet()){
            int f = map.get(num);
            if(bucket[f] == null)
                bucket[f] = new ArrayList<>();
            bucket[f].add(num);
        }
        for(int i = bucket.length-1;i >=0 && result.size() < k;i--){
            if(bucket[i] != null){
                for(int j = 0;j < bucket[i].size() && result.size() < k;j++){
                    result.add(bucket[i].get(j));    
                }
            }
        }
        return result;    
    }
}
