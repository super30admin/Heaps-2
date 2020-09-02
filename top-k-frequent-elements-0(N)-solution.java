/*

Did it run on leet code: Yes
Did you face any problem: No

Time Complexity: 0(N)
Space Complexity: 0(N)

Algorithm:
- Create a hashmap to store frequencies of the elements (element,frequency_of_element)
- Create a bucket (Array of ArrayList)al which is equal to size of input (ie worst case every element is unique)
- In al[i], where `i` is the index of array will denote the frequency the values will be the elements which has frequency
equal to `i`.
- Loop out `al` from back ie i = size..0 and add elements in result where al[i]!=null

- Input = [1,1,2,2,3]
- HashMap = {1:2,2:2,3:1}
- al = [ null, (3),(1,2),null,null,null]
- index = 0,    1,   2,   3,   4,   5

*/


class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        int size = nums.length;
        Map<Integer,Integer> frequency = new HashMap<>();
        ArrayList<Integer>[] al = new ArrayList[size+1];
        
        for(int num:nums){
            frequency.put(num,frequency.getOrDefault(num,0)+1);
        }
        
        for(int key: frequency.keySet()){
            int val = frequency.get(key);
            if(al[val]==null){
                al[val] = new ArrayList<Integer>();
            }
            al[val].add(key);
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i=size;i>=0 && result.size()<=k;--i ){
            
            if(al[i]!=null){
                result.addAll(al[i]);
            }
        }
        
        if(result.size()>k){
            return result.subList(0,k);
        }else{
            return result;
        }
        
    }
}