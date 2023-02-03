// Time Complexity : O(n)
// Space Complexity :O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums==null || nums.length==0) return new int[]{};
        int[] res=new int[k];
       
        int max=0;
        
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            max=Math.max(max,map.get(nums[i]));
        }
        
        List[] list=new List[max+1];
        
        for(int key:map.keySet()){
            int index=map.get(key);
            
            if(list[index]==null){
                list[index] = new ArrayList<>();
            }
            
            list[index].add(key);
        }
        
        for(int i=max;i>=0 && k>0; i--){
            List<Integer> li=list[i];
            if(li==null) continue;
            for(int j=0;j<li.size() && k>0;j++){
                res[k-1] = li.get(j);
                k--;
            }
           
            
        }
        return res;
    }
}