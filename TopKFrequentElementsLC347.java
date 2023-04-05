class Solution {
    
    
    //Time Complexity: O(n)
    
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> numToFreq = new HashMap<>();
        
        for(int num: nums){
            
            numToFreq.put(num, numToFreq.getOrDefault(num, 0)+1);
        }
        
        Map<Integer, List<Integer>> freqToNum = new HashMap<>();
        
        for(int num: numToFreq.keySet()){
            
            int freq = numToFreq.get(num);
            
            if(!freqToNum.containsKey(freq)){
            
                freqToNum.put(freq, new ArrayList<>());
            }
            
            freqToNum.get(freq).add(num);
        }
        
        int[] result = new int[k];
        
        for(int i=nums.length; i>=0; i--){
            
            if(freqToNum.containsKey(i)){
                
                List<Integer> freq = freqToNum.get(i);
                
                for(int num : freq){
                    
                    result[--k] = num;
                    
                    if(k==0){
                        return result;
                    }
                }
            }
        }
        return result;
    }
    
    
    
    
    
    
    
    
    
    //Time Complexity: O(n*log(n))
    
    
//     public int[] topKFrequent(int[] nums, int k) {
        
//         Map<Integer, Integer> map = new HashMap<>();
        
//         for(int num: nums){
            
//             map.put(num, map.getOrDefault(num, 0)+1);
//         }
        
//         Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        
//         for(int key : map.keySet()){
//             minHeap.add(key);
//             if(minHeap.size()>k){
//                 minHeap.poll();
//             }
//         }
        
//         int[] result = new int[minHeap.size()];
//         int index = 0;
        
//         while(!minHeap.isEmpty()){
//             result[index++] = minHeap.poll();
//         }
//         return result;
//     }
}
