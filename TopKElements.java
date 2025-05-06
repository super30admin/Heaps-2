//Time Complexity : O(n);
// Space Complexity :O(n);
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        HashMap< Integer , List<Integer>> freqmap = new HashMap<>();
        for(int key : map.keySet()){
            int freq = map.get(key);
            min = Math.min(min,freq);
            max = Math.max(max,freq);
            if(!freqmap. containsKey(freq)){
                freqmap.put(freq,new ArrayList<>());
            }
            freqmap.get(freq).add(key);
        }
        int[] result = new int [k];
        int j =0;
        for (int i = max;i>=min && j<k;i--){
            List<Integer> li = freqmap.get(i);
            if(li==null) continue;
            for(int f =0 ; f<li.size()&& j<k ;f++){
                int el = li.get(f);
                result[j]=el;
                j++;
            }
        }
        return result;

        
    }
}