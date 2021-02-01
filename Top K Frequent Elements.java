// Time Complexity : O(n log k)
// Space Complexity : O(n+k)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
//iterate over array calculate num repetitions, use priority queue of size k, min heap, sort by count[n]
//keep adding nums remove heap top when heap size >k 

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        
        for(int n : nums){
            count.put(n, count.getOrDefault(n, 0)+1);
        }
        
        Queue<Integer> pq = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
        
        for(int n : count.keySet()){
            pq.add(n);
            
            if(pq.size()>k)
                pq.poll();
        }
        
        int[] res = new int[k];
        int i=k-1;
        while(!pq.isEmpty()){
            res[i] = pq.poll();
            i--;
        }
        
        return res;
    }
}