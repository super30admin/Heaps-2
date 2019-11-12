class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> result = new ArrayList<>();
      
    HashMap<Integer, Integer> map = new HashMap();
      
    for (int n: nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    
    PriorityQueue<Integer> pq =
            new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));

    
    for (int n: map.keySet()) {
      pq.add(n);
      if (pq.size() > k)
        pq.poll();
    }

    
    while (!pq.isEmpty())
      result.add(pq.poll());
   
    return result;
  }
}
