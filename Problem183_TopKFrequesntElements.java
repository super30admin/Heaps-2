//Time Complexity: O(nlog(n))
//using HashMap and Heaps
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //creating hashMap of numbers and its occurence(frequency)
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //creating heap to maintain only k max elements
        //a minHeap is created
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(int key : map.keySet()){
            heap.add(key); 
        }
        iterate over the heap, poll k elements
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < k; i++){
            result.add(heap.poll());
        }
        //print the resultant list
        return result;
    }
}

/*************************************************************************************************** */

//Time Complexity: O(n)
//Bucket Sort
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        //HashMap to store keys with their respective frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        //List of dynamic arrayLists int the list to store all keys for the respective frequencies
        List<Integer> [] buckets = new List[nums.length + 1];
        //1.creating map
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //2.iterating over map to add keys into the buckets
        for(int key : map.keySet()){
            int frequency = map.get(key);
            //get buckets; if null -> add new list and then add key
            //if exists; simply add key
            if(buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        //3. iterate over the buckets from the end of lists to print top k keys
        for(int i = buckets.length - 1; i >= 0 && result.size() < k; i--){
            if(buckets[i] != null){
                result.addAll(buckets[i]);
            }
        }
        return result;
    }
}