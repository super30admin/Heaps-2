/******
Time O(klogn)
Space O(n)
Leetcode yes
Problem no
****/

class Solution {
    
    class Pair{
        int key,frequency;
        
        public Pair(int key , int frequency)
        {
            this.key = key;
            this.frequency = frequency;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        //Storing frequency
        for(int i =0 ; i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],1);
            else
                map.put(nums[i],map.get(nums[i])+1);
        }

        //Making heap of size k
        PriorityQueue<Pair> q = new PriorityQueue<>( (a,b) -> a.frequency- b.frequency);
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {   
            if(q.size()<k)
                q.add(new Pair(entry.getKey(),entry.getValue()));
            else
            {
                Pair temp = q.peek();
                if(map.get(temp.key) < map.get(entry.getKey()))
                {
                    q.poll();
                    q.add(new Pair(entry.getKey(),entry.getValue()));
                }
            }
        }
            
      List<Integer> result = new ArrayList<>();
       while(!q.isEmpty())
           result.add(q.poll().key);
       
     return result;
    }
}
