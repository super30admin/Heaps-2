//347 K frequent elements
// Time _ O(n)
// space O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> keyToFrequency = new HashMap();
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length;i++){
            
            if(!keyToFrequency.containsKey(nums[i])){
                keyToFrequency.put(nums[i], 0);
            }
            keyToFrequency.put(nums[i], keyToFrequency.get(nums[i]) + 1);
            max = Math.max(max, keyToFrequency.get(nums[i]) + 1);
        }
        
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap();
        
        for(int key: keyToFrequency.keySet()){
            
            int freq = keyToFrequency.get(key);
            
            if(!map.containsKey(freq)){
                map.put(freq, new ArrayList());
            }
            
            map.get(freq).add(key);
        }
        
        int[] result = new int[k];
        
        int i = 0;
        
        while(k > 0){
            if(map.containsKey(max)){
                
                List<Integer> list = map.get(max);
                
                for(int j = 0; j < list.size() && k > 0 ; j++){
                    
                    result[i] = list.get(j);
                    i++;
                    k--;
                }
            }
            max--;
        }
        return result;
        
    }
}