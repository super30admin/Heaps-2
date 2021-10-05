# Heaps-2

## Problem1: Top K Frequently Repeating Elements(https://leetcode.com/problems/top-k-frequent-elements/)

// Time - Complexity = O(NlogK)
//Space Complexity = O(N)

class Solution {
public int[] topKFrequent(int[] nums, int k) {
if(nums== null || k == 0 || nums.length == 0) {
return new int[0];
}

        HashMap<Integer,Integer> map = new HashMap();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        for(Integer i : map.keySet()) {

            queue.add(i);
            if(queue.size() > k) {
                queue.poll();
            }
        }

        int[] result = new int[queue.size()];
        int i = 0;
        while(!queue.isEmpty()) {
            result[i] = queue.poll();
            i++;
        }
        return result;
    }

}

// Time - Complexity = O(N)
// Space Complexity = O(N)

class Solution {
public int[] topKFrequent(int[] nums, int k) {
if(nums == null || nums.length == 0) {
return new int[0];
}
int[] result = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(Integer i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            max = Math.max(max, map.get(i));
        }

        List[] buckets = new List[max + 1];

        for(Integer key : map.keySet()) {
            int freq = map.get(key);
            if(buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        for(int i = buckets.length - 1; i >= 0 && k > 0; i--) {
            List<Integer> bucket = buckets[i];
            if(bucket != null) {
                for(int j = bucket.size()-1; j >= 0 && k > 0; j--) {
                    result[--k] = bucket.get(j);
                }
            }
        }


        return result;
    }

}
