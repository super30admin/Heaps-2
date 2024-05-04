//TimeComplexity:O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<nums.length;i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i])+1);
        }

        int min = nums.length;int max =0;
        HashMap<Integer, List<Integer>> values = new HashMap<>();
        for(int key:map.keySet()) {
            int value = map.get(key);
            min = Math.min(min, value);
            max = Math.max(max, value);
            if(!values.containsKey(value)) {
                values.put(value, new ArrayList<>());
            }
            values.get(value).add(key);
        }
        int []result = new int[k];
        int index=0;
        for(int i =max;i>=min;i--) {
            List<Integer> li = values.get(i);
            if(li!=null) {
                for(int j =0; j<li.size() && index<k;j++) {
                    result[index] = li.get(j);
                    index++;
                }
            }
        }
        return result;
    }
}