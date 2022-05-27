import java.util.*;
/*
Time Complexity: O(nlogk), n is the number of elements in the given nums array, and k is the number of the top
frequent elements
Space Complexity: O(k) Priority Queue size
Run on Leetcode: Yes
Any difficulties: no

Approach:
1. Creating a frequency map and then adding elements into the heap based on their occurrence based on the value of k
2. Iterate over the keyset of the frequency map, and then create the result using the heap values
 */
public class TopKFrequentElements {
    public static int[] topKFrequentElements(int[] nums, int k){
        if(k == nums.length){
            return nums;
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2)-> map.get(n1)-map.get(n2));

        for(int num: map.keySet()){
            heap.add(num);
            if(heap.size()>k){
                heap.poll();
            }
        }

        int[] result = new int[k];

        for(int i =0; i<k; i++){
            result[i] = heap.poll();
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println("Top K Frequent elements: "+ Arrays.toString(topKFrequentElements(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println("Top K Frequent elements: "+ Arrays.toString(topKFrequentElements(new int[]{1}, 1)));
    }
}
