class Sample{
    //TC:0(nlogK)
    //SC:0(n)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            if(nums==null || nums.length==0 || k==0){
                return new int[]{};
            }

            HashMap<Integer,Integer> count=new HashMap<>();
            for(int num:nums){
                count.put(num,count.getOrDefault(num,0)+1);
            }

            PriorityQueue<Integer> heap=new PriorityQueue<>((a,b)->count.get(a)-count.get(b));
            for(int key:count.keySet()){
                heap.add(key);
                if(heap.size()>k){
                    heap.poll();
                }
            }
            int[] result=new int[k];
            for(int i=0;i<k;i++){
                result[i]=heap.poll();
            }

            return result;
        }
    }
}