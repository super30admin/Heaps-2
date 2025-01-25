class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        HashMap<Integer , List<Integer>> freqToNumMap = new HashMap<>();
        int min= 0, max = 0;

        for(int key: map.keySet()){
            int freq = map.get(key);
            if(!freqToNumMap.containsKey(freq)){
                freqToNumMap.put(freq, new ArrayList<>());
            }
            freqToNumMap.get(freq).add(key);
            min = Math.min(min , freq);
            max = Math.max(max , freq);
        }

        int[] result = new int[k];
        int idx = 0;
        for(int i=max;i>=min && idx  < k;i--){
            if(!freqToNumMap.containsKey(i)) continue;
            List<Integer> lst = freqToNumMap.get(i);

            for(int j=0;j<lst.size() && idx<k;j++){
                result[idx] = lst.get(j);
                idx++;
            }
        }

        return result;

    }
}