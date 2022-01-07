//TC: O(N)
//SC: O(N)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
    if( k == nums.length)
            return nums;
        
	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

	for (int n : nums)
		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
	
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2) -> frequencyMap.get(n1) - frequencyMap.get(n2));
        
        for(int n: frequencyMap.keySet()){
            heap.add(n);
            if(heap.size() > k) heap.poll();
        }
        
        int[] top = new int[k];
        
        for(int i = k-1; i>=0; i--)
            top[i] = heap.poll();
        
        return top;
    }
}