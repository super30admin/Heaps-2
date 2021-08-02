//Array of List approach
//Time Complexity : O(n)
//Space Complexity : O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //array of lists
        List[] res = new List[nums.length+1];//as freq is always greater than 1
        int[] result = new int[k];
        if(nums==null || nums.length==0){
            return new int[]{};
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //use the array index as the frequency and each list as the list of elements with that freq
        for(int key : map.keySet()){
            int idx = map.get(key);
            if(res[idx]==null){
                res[idx] = new ArrayList<>();
            }
            res[idx].add(key);
        }
        //return the list of ele with max freq
        for(int i=nums.length;i>=0 && k>0;i--){
            List<Integer> li = res[i];
            if(li!=null){
                for(int j=0;j<li.size() && k>0;j++){
                    result[k-1] = li.get(j);
                    k--; 
                }
            }
        }
        return result;
        
    }
}
/*
//Heap apprach
//Time Complexity : O(nlog k).k elements are inseted into the heap
//Space Complexity : O(n). in the worst case the k will be eual to n
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        if(nums==null || nums.length==0){
            return new int[]{};
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //implement min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return map.get(a)-map.get(b);
        });
        //include only k elements : so at the end only max freq elements will be present in the queue
        for(int val : map.keySet()){
            pq.add(val);
            if(pq.size()>k){
                pq.poll();
            }
        }
        //add all rem elements from heap into result array
        while(k>0){
            res[k-1] = pq.poll();
            k--;
        }
        return res;
    }
}
*/