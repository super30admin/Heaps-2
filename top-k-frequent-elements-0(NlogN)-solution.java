/*


Did it run on leet code: Yes
Did you face any problem: No

Time Complexity: 0(NlogN)
Space Complexity: 0(N)

Algorithm:
- create a hashmap to store frequencies
- create a priority queue and sort elements based on frequency
- remove element at every step 

*/


class KeyFrequency{
    int key;
    int freq;
    public KeyFrequency(int key,int freq){
        this.key = key;
        this.freq = freq;
    }
    
    public int getKey(){ return this.key;}
    public int getFreq(){ return this.freq;}

}

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        int size = nums.length;
        Map<Integer,Integer> frequency = new HashMap<>();
        for(int num:nums){
            frequency.put(num,frequency.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<KeyFrequency> nodes = new PriorityQueue<>((obj1,obj2)->{
            return obj1.getFreq()>obj2.getFreq()?-1:1;
        });
        
        for(int key:frequency.keySet()){
            nodes.add(new KeyFrequency(key,frequency.get(key)));
        }
        
        
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<k;++i){
            KeyFrequency elem = nodes.remove();
            result.add(elem.getKey());
        }
        
        return result;
    }
}