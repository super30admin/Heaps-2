class Solution {
    // tc-o(n) sc-o(n)
     public int[] topKFrequent(int[] nums, int k) {
         HashMap<Integer,Integer> map = new HashMap<>();
         int[] result = new int[k];
         for(int i=0;i<nums.length;i++)
         {
             map.put(nums[i], map.getOrDefault(nums[i],0)+1);
         }
         HashMap<Integer,List<Integer>> bucketmap = new HashMap<>();
         int min = nums.length;
         int max = 0;
         for(int key: map.keySet())
         {
             int count = map.get(key);
             min = Math.min(min,count);
             max = Math.max(max,count);
 
             if(!bucketmap.containsKey(count))
             {
                 bucketmap.put(count,new ArrayList<>());
             }
             bucketmap.get(count).add(key);
         }
         int j=0;
         for(int i=max;i>=min && j<k;i--)
         {
             List<Integer> li = bucketmap.get(i);
             if(li!=null)
             {
             for(int f =0;f<li.size() && j<k;f++)
             {
             result[j] = li.get(f);
             j++;
             }
             }
         }
         return result;
 
     }
 }