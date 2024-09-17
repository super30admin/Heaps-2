// Time Complexity : O(NlogK)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> map = new HashMap<>();
       List<Integer> result = new ArrayList<>();
       if(nums==null || nums.length==0 || k==0) return new int[0];
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
                
            }
            else{
                map.put(nums[i],1);
                
            }
                        
        }
        
        // for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
        // if(entry.getValue()>=k){
        //     result.add(entry.getKey());
        // }
        // }
        
        Comparator<Map.Entry<Integer,Integer>> customComparator = new Comparator<>(){
        public int compare(Map.Entry<Integer,Integer> a ,Map.Entry<Integer,Integer> b){
            return a.getValue()-b.getValue();
        }
            };
        PriorityQueue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>(customComparator); 
        Iterator it = map.entrySet().iterator();
        int counter =1;
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            if(counter<=k){
            q.add(pair);
            counter++;
            }
            else{
                if((int)pair.getValue()>(int)q.peek().getValue()){
                    q.poll();
                    q.add(pair);
                }
            }
        }
        
        while(!q.isEmpty()){
            result.add((int)q.poll().getKey());
        }
        int[] res = new int[result.size()];
        for(int i=0;i<result.size();i++){
            res[i] = result.get(i);
        }
        return res;
    }
}
