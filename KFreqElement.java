//Time - O(n log k) --> O(n) for hashmap, lg k for PriorityQueue;
//Space - O(n)

class Solution {
    
    class Pair{
        int num;
        int freq;
        
        public Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || k ==0)
            return new int[]{};
        
        int[] result = new int[k];
        Map<Integer, Pair> freqMap = new HashMap<>();
        
        for(int n: nums){
            
            if(freqMap.containsKey(n)){
                Pair p = freqMap.get(n);
                p.freq += 1;
                freqMap.put(n, p);
            }else{
                Pair p = new Pair(n, 1);
                freqMap.put(n, p);
            }
        }
        
       
        Comparator<Pair> custom = new Comparator<Pair>(){
               @Override
                public int compare(Pair p, Pair q){
                    return p.freq - q.freq;
                }
        };
    
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(custom);
        
        int i = 0;
        
        for(Map.Entry<Integer, Pair> entry : freqMap.entrySet()){
            Pair p = entry.getValue();
            if(k>0){
                minHeap.add(p);
                k--;
            }else{
                if(minHeap.peek().freq <= p.freq){
                    minHeap.remove();
                    minHeap.add(p);
                } 
            }

        }

        while(minHeap.size() >0){
            Pair p = minHeap.poll();
            result[i] = p.num;
            i++;
            // minHeap.remove();
        }

        return result;
    }
}
