// TC = O(N)
//SC = O(N+K)
//Here we are first making count map of the numbers in array. then using PQ to get filter K element.
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map  = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a)-map.get(b));
        for(Integer key : map.keySet()){
            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }
        }

        int res[] = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            res[i] = pq.poll();
            i++;
        }
        return res;
    }
}