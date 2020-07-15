// Time  complexity : O(N * log(n-k))
//  space complexity : O(N)

// worked in leetcode : YES
public class TopKFrequentElements {
    
    
    class Node{
        int item;
        int count;
        
        public Node(int item, int count){
            this.item = item;
            this.count = count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        
        
        int [] res = new int[k];
        int idx = 0;
        PriorityQueue <Node> pq = new PriorityQueue<>((a,b) -> b.count - a.count);
        Map<Integer, Node> map  = new HashMap();
//      // get count
        for (int i : nums){
            if (map.containsKey(i)){
                Node node = map.get(i);
                node.count+=1;
                map.put(i, node);
            }else{
                map.put(i,new Node(i,1));    
            }
            
        }
        int n = map.size();
        // add map values to priority queue
        for(Integer key :  map.keySet()){
            pq.add(map.get(key));
            if(pq.size() > n - k){
                
                Node p = pq.poll();
                // l.add(p.item);
                res[idx] = p.item;
                idx++;
            }
        }
        return res;
    }
}