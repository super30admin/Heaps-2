/**

-> MAp -> element to frequency

1 -> 3
2 -> 2

6 

O(N) + O(klogk) + O(logK)

2->2, 1 -> 3

TC - O(N) + O(KlogK) 
SC - O(K) 

**/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        final Map<Integer, Integer> valueToFrequency = new HashMap<>();
        
        
        for (int num: nums)
        {
            valueToFrequency.put(num, valueToFrequency.getOrDefault(num, 0) + 1);
        }
        
        // 2 -> 2, 1 -> 3 
        
        final Queue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        
        for (Map.Entry<Integer, Integer> entry : valueToFrequency.entrySet())
        {     
            pq.add(entry);
            
            if (pq.size() > k)
            {
                pq.remove();
            }
        }
        
        int result[] = new int[k];
        int count = 0;
        
           while(!pq.isEmpty())
           {
               result[count] = pq.remove().getKey();
               count++;
           }
       
        return result;
    }
}
