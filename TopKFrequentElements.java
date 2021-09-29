//TC - O(N) - number of words
//SC - O(2N) - N - number of words - map, heap

class Solution {
  public int[] topKFrequent(int[] nums, int k) {


    Map<Integer, Integer> map = new HashMap<>();

    for(int num: nums){
      map.put(num, map.getOrDefault(num,0)+1);
    }

    Queue<Integer> heap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));


    for(int num: map.keySet()){
      heap.add(num);
    }

    int[] result = new int[k];

    for(int i=0; i<k ;i++){
      result[i] = heap.poll();
    }


    return result;
  }
}
