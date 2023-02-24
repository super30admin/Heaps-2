// Time Complexity : O(2n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;
class TopKFrequentRepeat {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int num :nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> maxheap = new PriorityQueue<>(
            (a,b) -> b.getValue()-a.getValue()
        );

        for (Map.Entry<Integer,Integer> set : map.entrySet()){
            maxheap.add(set);
        }

        int[] result = new int[k];
        int cnt =0;
        while (cnt <k){
            result[cnt]= maxheap.poll().getKey();
            cnt++;
        }
        return result;
        
    }
}