
// O(nlogk)
import static java.util.Collections.max;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int[] result = new int[k];
        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b)-> map.get(a)-map.get(b));

        for(int n: map.keySet()){
            minHeap.add(n);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        for(int i= k-1;i>=0;--i){
            result[i] = minHeap.poll();
        }

        return result;

    }
}
