//time complexity O(nlogk)
//space complexity O(n) size of hashmap. priority queue and result array can be neglected because k is constant and negligible
//APPROACH 1: using priority queue, hashmap and result array
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        for(int num: nums){//O(n)
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            return map.get(a) - map.get(b);
        });
        for(int key: map.keySet()){//O(n)
            pq.add(key);
            if(pq.size() > k){
                pq.poll();
            }
        }
        for(int i = 0; i < k; i++){
            result[result.length -1 - i] = pq.poll();
        }
        return result;
    }
}

//time complexity O(n)
//space complexity O(2n)
//APPROACH 2: without using priority queue
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        List<Integer> [] buckets = new List[nums.length + 1];//because in edge case of only one element freq will be 1 i.e. the size atleast need to be 1
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int key : map.keySet()){
            int f = map.get(key);
            if(buckets[f] == null){
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(key);
        }
        for(int i = buckets.length - 1; i >= 0 && k > 0; i--){
            if(buckets[i] != null){
                for(int j = 0; j < buckets[i].size() && k > 0; j++){
                    result[result.length - k] = buckets[i].get(j);
                    k--;
                }
            }
        }
        return result;
    }
}
