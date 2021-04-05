//TC: O(NlogK) -> O(N) if N = K
//SC: O(N+K) -> hashmap size + PriorityQueue size
// Did it run successfully on Leetcode?: Yes
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Store the frequency of every number in HashMap
        int res[] = new int[k];
        HashMap<Integer, Integer> map = new HashMap();
        for (int num:nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue minHeap = new PriorityQueue((l1, l2) -> map.get(l1) - map.get(l2));
        
        for(int key: map.keySet())         
        {
            minHeap.offer(key);
            if (minHeap.size() > k)
                // minHeap.poll() always removes the min element from heap. Here it is the element with lowest frequency.
                minHeap.poll();
        }
        // minHeap.poll() always removes the min element from heap, start filling the array from right to left. So left most element in array will have element with highest frequency and right most element of the array will have lowest frequency
        for (int i = k-1; i >= 0; i--)
        {
            res[i] = (int)minHeap.poll();
        }
        return res;
    }
}


