// Bucket Sort
// TC: O(n)
// SC: O(n)

// Hashmap to map each number: frequencies
// Create a bucket of size n+1. Each index/bucket is a list
// the index of the bucket corresponds to frequencies from hashmap hence n+1.
// index 0 will always be empty in that case
// Fill bucket index with list items based on the frequency by iterating over the hashmap
// Iterate over the bucket in reverse for top k elements to find the non-empty list 
// Iterate over the non empty list as well 
// Both iterations until k is reduced to 0

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer>map = new HashMap<>();
        
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //create frequency list
        List[] liArr = new List[n+1]; //n items +1 for 0 index
        
        //ceating a bucket
        for(int num:map.keySet()){
            int freq=map.get(num); //freq is your index in liArr
            if(liArr[freq]==null){
                liArr[freq]=new ArrayList<>();
            }
            List<Integer> li= liArr[freq];
            li.add(num);
        }
        //result array
        int[] result = new int[k];
        
        for(int i=n;i>0 && k>0;i--){
            List<Integer> li= liArr[i];
            if(li!=null){
                for(int j=0;j<li.size() && k>0;j++){
                    k--; //decrement first because ex. k=2, index=1, k=1, index=0
                    result[k]=li.get(j);
                }
            }
        }
        return result;
    }
}


// HashMap and reversed hashmap(value:keys) 
// TC: O(n)
// SC: O(n)

// One hashmap of number:freq
// We get the max value of freq so that we know that one or some or all elements with max freq would
// be the top K elements
// Create another hashmap freqMap reversed  freq:List[nums]
// Iterate over the freqmap starting at i=max, and also k>0 in same for loop
// We are looping over every value List starting from i=max and decrementing i and k 
// The values which we get from the list are added onto the result array of size k
// NOTE: first decrement k and then assign value to result array because of index offset


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer>map = new HashMap<>();
        
        int max=0;
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            max=Math.max(max,map.get(num)); //get max freq
        }
       
        //max freq will be the top k(nth) element
        
        // freq map
        HashMap<Integer,List<Integer>> fmap = new HashMap<>();
        
        for(int num:map.keySet()){
            int freq=map.get(num); //freq is your index in liArr
            if(!fmap.containsKey(freq)){
                fmap.put(freq,new ArrayList<>());
            }
            List<Integer> li=fmap.get(freq);
            li.add(num);
        }
        //result array
        int[] result = new int[k];
        
        for(int i=max;i>0 && k>0;i--){
            List<Integer> li= fmap.get(i);
            if(li!=null){
                for(int j=0;j<li.size() && k>0;j++){
                    k--; //decrement first because ex. k=2, index=1, k=1, index=0 (index offset)
                    result[k]=li.get(j);
                }
            }
        }
        return result;
    }
}

// Min Heap Solution
// TC: O(n log k)
// SC: O(n)

// Create a hashmap for num:freq
// Create a prority queue (min heap) based on sorting a-b of map values (freq)
// Add keys from hashmap to the queue and if heap size > k, 
//poll the elements
// So based on frequency, we are adding the keys to the heap
// Remaining elements in heap(pq) will be the top k elements (largest frequencies)

// Poll the heap and add it to a resulting array


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer>map = new HashMap<>();
        
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(int num:map.keySet()){
            int freq=map.get(num);
            pq.add(num);
            if(pq.size()>k) pq.poll();
        }
        
        int[] result = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            result[i]=pq.poll();
            i++;
        }
        return result;
    }
}


