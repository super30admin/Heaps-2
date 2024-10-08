//TC = O(N*logK)
//SC = O(K)
class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] frequentElements = new int[k];

        // hashmap to store the frequency of the element
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : nums) { // O(N)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Build heap of size k to store element with most frquency - min heap
        PriorityQueue<Integer> pq = new PriorityQueue((num1, num2) ->
                frequencyMap.get(num1) - frequencyMap.get(num2));

        for(int n : frequencyMap.keySet()) { // O(N*logK)
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }

        for(int i = k - 1; i >= 0; i--) { // O(k*log*k)
            frequentElements[i] = pq.poll();
        }
        return frequentElements;
    }
}