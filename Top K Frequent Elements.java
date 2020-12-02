//Time Complexity-O(n)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap();
        int max=0;
        for(int num:nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
            max=Math.max(max,map.get(num));
        }
        HashMap<Integer,List<Integer>>mapCount=new HashMap();
        for(int key:map.keySet())
        {
            mapCount.putIfAbsent(map.get(key),new ArrayList());
            mapCount.get(map.get(key)).add(key);
        }
        int[]output=new int[k];
        int i=0;
        while(i<k)
        {
            if(mapCount.containsKey(max))
            {
                for(int ele:mapCount.get(max))
                {
                    output[i]=ele;
                    i++;
                }
            }
            max--;
        }
        return output;
    }
}