// 347.
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //edge
        if(nums == null || nums.length == 0)
        {
            return new int[0];
        }
        
        return bucketsApproach(nums, k);
    }
    
    //time - O(n log k)
    //space - O(n)
    private int[] minHeaps(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>(); //tracks counts of each element in nums[]
        for(int num : nums)
        {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        //min heap tracks the k most frequent elements - root is the least frequent element among the k elements in heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> counts.get(a) - counts.get(b));
        for(int num : counts.keySet())
        {
            //check if the current is more frequent than the least frequent (root)
            //if so remove root and add current
            if(minHeap.size() < k)
            {
                minHeap.offer(num);
            }
            else
            {
                if(counts.get(num) > counts.get(minHeap.peek()))
                {
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }  
        }
        
        int[] result = new int[k];
        int index = k - 1; //least frequent element is at the end of result[]
        while(index >= 0 && minHeap.size() != 0)
        {
            result[index--] = minHeap.poll();
        }
        
        return result;
    }
    
    // time - O(max(n, maxFreq)) - not suitable when maxfreq is very large than number of unique elements in nums[]
    // space - O(n)
    private int[] bucketsApproach(int[] nums, int k) {
        int maxFreq = Integer.MIN_VALUE; //tracks the freq of max freq element in nums[]
        HashMap<Integer, Integer> counts = new HashMap<>(); //tracks counts of each element in nums[]
        for(int num : nums)
        {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, counts.get(num)); //update maxfreq if needed
        }
        
        List<List<Integer>> buckets = new ArrayList<>(); 
        //each index in buckets list is inturn an list tracking all the elements with freq equals index of this list
        //eg - [1,1,1,2,2,3]
        //buckets - [[], [3], [2], [1]] -> 0 elements with 0 freq, only 3 is of freq 1, only 2 is of freq 2 and so on
        for(int i = 0; i <= maxFreq; i++)
        {
            //initially add empty array lists
            buckets.add(new ArrayList<>());
        }
        for(int num : counts.keySet()) 
        {
            //add current number into respective bucket
            buckets.get(counts.get(num)).add(num);
        }
        
        int[] result = new int[k];
        int index = 0;
        //start from max freq bucket
        int currentBucketIndex = maxFreq;
        while(index < k)
        {
            List<Integer> currentBucket = buckets.get(currentBucketIndex);
            //get all elements from current bucket and add to result[] till size of result[] < k
            if(currentBucket != null)
            {
                for(Integer num : currentBucket)
                {
                    result[index++] = num;
                }
            }
            currentBucketIndex--;
        }
        
        return result;
        
    }
}
