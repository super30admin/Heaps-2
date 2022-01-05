// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Make a hashmap to store the count, then creat a bucket to get the count to the keys list. once done go through the list from the end and set all the values to the result array
// Your code here along with comments explaining your approach
// using array bucket
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            hm.put(num, hm.getOrDefault(num, 0)+1);
            max = Math.max(max,hm.get(num));
        }
        List [] bucket = new List[max+1];
        for(int key: hm.keySet()){
            int index = hm.get(key);
            if(bucket[index] == null){
                bucket[index] = new ArrayList<>();
            }
            bucket[index].add(key);
        }
        int [] result = new int [k];
        for(int i = max; i > 0 && k > 0; i --){
            List <Integer> li = bucket[i];
            if(li != null){
                for(int j = 0; j < li.size() && k > 0; j++){
                    result[k-1] = li.get(j);
                    k--;
                }
            }
        }
        return result;
    }
}

// Time Complexity : O(nLog(k))
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// make a hashmap to store the count, then go through the key, value and add it to the priority queue, if pq.size is grater than k then pq.poll(); once done, remove all the element and store its key, zero index to the result array
// Your code here along with comments explaining your approach
// using Heap - priority Queue time: O(n*Log(k)) - space: O(k)
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         HashMap<Integer,Integer> hm = new HashMap<>();
//         for(int num : nums){
//             hm.put(num,hm.getOrDefault(num, 0)+ 1);
//         }
//         PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
//         for(int key : hm.keySet()){
//             pq.add(new int[] {key, hm.get(key)});
//             if(pq.size() > k){
//                 pq.poll();
//             }
//         }
//         int [] result = new int [k];
//         for(int i = k-1; i >= 0; i--){
//             int [] arr = pq.poll();
//             result[i] = arr[0];
//         }
//         return result;
//     }
// }