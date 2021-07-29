import java.util.*;

public class TopKFrequentElements {

    //Bucket approach - Create frequency List and iterate from the last.
    //Create frequency hash map
    //Create Array of list of total number of element
    //Fill the frequency with the number - If it has similar frequency update the list
    //Traverse reverse order and fill the result
    //TC:O(N) where N is the number of elemnts (nums)
    //SC:O(N) - Array list used for buckets.
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        if (nums == null || nums.length == 0)
            return result;
        HashMap<Integer, Integer> map = new HashMap();

        // Frequency map builder
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List[] buckets = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int value = map.get(key);
            if (buckets[value] == null) {
                buckets[value] = new ArrayList();
            }
            buckets[value].add(key);
        }

        int position = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            List<Integer> currentList = buckets[i];
            if (currentList != null && currentList.size() > 0) {
                for (int item : currentList) {
                    if (position < k) {
                        result[position] = item;
                        position++;
                    }

                }
            }

        }

        return result;
    }

    // TC: O(KlogN) where N is number of elements.
    // SC: O(N)
    // Min Heap solution
    // Generate frequency hash map
    // Create a priority queue with the custom comparator - Based ont the freqency
    // we have created the hash map.
    // For each key put it in the priority queue if it crossed the k poll it. In
    // that way we will be having highes priorities will be at the bottom. lowest
    // priorities will get removed.
    // Iterated reverse order to get sorted way.
    public int[] topKFrequentPriorityQueueApproach(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[] {};
        HashMap<Integer, Integer> map = new HashMap();

        // Frequency map builder
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue((a, b) -> map.get(a) - map.get(b));

        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        int i = k - 1;
        while (!pq.isEmpty()) {
            result[i] = pq.poll();
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] result = topKFrequentElements.topKFrequent(new int[]{1,1,1,1,2,2,2,3,3,3}, 2);
        System.out.println("The result:"+ result);
    }
}
