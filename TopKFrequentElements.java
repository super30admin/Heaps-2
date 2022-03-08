// Time Complexity: O(n + max(k,m))
// Spae Complexity: O(n + max frequency)
// QuickSelect algorithm
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int [] result  = new int[k];
        if(nums == null || nums.length == 0)
            return result;
        
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE; // max freq count
        
        // create map of values and count
        for(int n : nums)  // O(n)
        {
            map.put(n, map.getOrDefault(n, 0)+1);
            max = Math.max(max, map.get(n));
        }
        
        // bucket for all freq holding list of numbers with that feq
        List [] buckets = new List[max+1]; // max+1 since we want max index
        
        // key = number val = freq
        for(int key : map.keySet()) // O(m)
        {
            // get freq index
            int index = map.get(key);
            if(buckets[index]  == null)
                buckets[index] = new ArrayList<>();
            // add numbers for that freq
            buckets[index].add(key);
        }
        
        int idx = 0;
        // start from max freq number 
        for(int i = max ; i >= 0 && k > 0 ; i --)
        {
            List<Integer> nos = buckets[i];
            if(nos != null)
            {
                for(int j = 0 ; j < nos.size() && k > 0; j++ , k-- )
                {
                    result[idx++] = nos.get(j);
                }
            }
        }
        
        return result;
    }
}
// Time Complexity: O(n + mlogk)
// Spae Complexity: O(n + k)
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int [] result  = new int[k];
        if(nums == null || nums.length == 0)
            return result;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        // create map of values and count
        for(int n : nums)
        {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        
        // create min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        
        // sort min priority of size k
        for(int key : map.keySet())
        {
            pq.offer(new int[]{key, map.get(key)});
            
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        
       //copy over values
        for(int i = k-1 ; i >= 0 ; i--)
        {
            int [] polled = pq.poll();
            result[i] = polled[0];
        }
        
        return result;
    }
}
