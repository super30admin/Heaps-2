package heaps2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	//Time Complexity : O(n), where n is length of array nums
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int[] topKFrequent(int[] nums, int k) {
        // null
        if(nums == null || nums.length == 0)
            return new int[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            max = Math.max(max, map.get(i));
        }
        
        List[] freq = new List[max + 1];
        
        for(int i: map.keySet()) {
            int count = map.get(i);
            if(freq[count] == null)
                freq[count] = new ArrayList<>();
            freq[count].add(i);
        }
        
        int[] res = new int[k];
        while(k > 0) {
            List<Integer> li = freq[max];
            if(li != null) {
                for(int i=0; i<li.size(); i++) {
                    res[k - 1] = li.get(i);
                    k--;
                    if(k == 0)
                        return res;
                }
            }
            max--;
        }
        
        return res;
    }
	
	//Time Complexity : O(n log k), where n is length of array nums and k is the size of min Heap
	//Space Complexity : O(k)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int[] topKFrequent1(int[] nums, int k) {
        // null
        if(nums == null || nums.length == 0)
            return new int[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(int i: map.keySet()) {
            minHeap.add(i);
            if(minHeap.size() > k)
                minHeap.poll();
        }
        
        int[] result = new int[minHeap.size()];
        for(int i=result.length - 1; i>=0; i--)
            result[i] = minHeap.poll();
        
        return result;
    }
}
