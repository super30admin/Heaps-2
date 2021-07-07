
import java.util.*;

import java.util.*;

//Time Complexity : O(N Log K) for HEAP ,O(N) for Bucket Sort

//Space Complexity : O(N) for HashMap
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/*
 * A.)HashMap +  Heap Approach
 * 1.)The first step is to build a hash map element -> its frequency
 * This step takes O(N) time where N is number of elements in the list.
 * 2.)The second step is to build a heap. The time complexity of adding an element in a heap is O(log(k)) 
 * 3.) We do addition of element in heap K times that means O(Nlog(k)) time complexity for this step.
 * 
 * 
 * B.) HashMap +  Bucket Sort 
 * 1.)The first step is to build a hash map element -> its frequency.This step takes O(N) time where N is number of elements in the list.
 * 2.)Create N + 1 buckets for storing the frequency.
 * 3.(Each Bucket storing the elements with k Frequency
 * 4.(Finally start traversing bucket in reverse direction.Also keep check size of bucket.If it  is less than K
 * add to result otherwise discard it
 * 
 * 
 * Bucket Sort is good for smaller or medium size array.For Large numbers or datea stream,usage of buckets can
 * be wastage of space.This may not work well for time-sensitive application such as google search result
 * 
 * C.)  HashMap + QuickSelect
 * 1.) The first step is to build a hash map element -> its frequency.This step takes O(N) time where N is number of elements in the list.
 * 2.) Creation Frequency array to store frequency
 * 3.) Apply Quick Select to find Kth Largest Frequency
 * 4.) Run a simple loop to find numbers with frequency greater than kth largest frequency
 * 
 * 
 * */
public class TopKFrequentRepeatingElement {
    public static Random rand = new Random();

	public List<Integer> topKFrequentHeap(int[] nums, int k) {
		List<Integer> output = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>(k);
		if (nums == null || nums.length == 0) {
			return output;
		}
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> map.get(a) - map.get(b));

		for (int num : map.keySet()) {
			heap.add(num);
			if (heap.size() > k) {
				heap.poll();
			}
		}
		output = new ArrayList<>(heap);
		Collections.reverse(output);
		return output;
	}

	public List<Integer> topKFrequentBucket(int[] nums, int k) {
		List<Integer> output = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>(k);
		if (nums == null || nums.length == 0) {
			return output;
		}
		List<Integer>[] buckets = new List[nums.length + 1];
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (int key : map.keySet()) {
			int f = map.get(key);
			if (buckets[f] == null) {
				buckets[f] = new ArrayList<>();
			}
			buckets[f].add(key);
		}
		for (int i = buckets.length - 1; i >= 0 && output.size() < k;) {
			if (buckets[i] != null) {
				output.addAll(buckets[i]);
			}
			i--;
		}
		return output;
    }
    
    public List<Integer> topKFrequentQuickSelect(int[] nums, int k) {
		List<Integer> output = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>(k);
		if (nums == null || nums.length == 0) {
			return output;
		}
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int frequency[] = new int[map.size()];
        int index = 0;
        for(final int value : map.values()){
            frequency[index++] = value;
        }
        final int kthLargest = quickSelectRec(frequency,0,index - 1,index - k);
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() >= kthLargest){
                output.add(entry.getKey());
            }
        }
		return output;
    }

    public int quickSelectRec(int nums[], int low, int high, int k) {
		if (low == high)
			return nums[low];

		int pivotIndex = low + rand.nextInt(high - low);

		pivotIndex = findPivot(nums, low, high, pivotIndex);

		if (k == pivotIndex)
			return nums[k];
		else if (k < pivotIndex)
			return quickSelectRec(nums, low, pivotIndex - 1, k);
		else
			return quickSelectRec(nums, pivotIndex + 1, high, k);
    }
    
    public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public int findPivot(int nums[], int low, int high, int pivotIndex) {

		int pivot = nums[pivotIndex];
		swap(nums, pivotIndex, high);
		int pIndex = low;
		for (int i = low; i < high; i++) {
			if (nums[i] <= pivot) {
				swap(nums, i, pIndex);
				pIndex++;
			}
		}
		swap(nums, pIndex, high);
		return pIndex;
	}

	public static void main(String args[]) {
		int nums[] = { 1, 1, 1, 2, 2, 3 };
		int k = 2;

		TopKFrequentRepeatingElement top = new TopKFrequentRepeatingElement();

		System.out.println(top.topKFrequentHeap(nums, k));
        System.out.println(top.topKFrequentBucket(nums, k));
        System.out.println(top.topKFrequentQuickSelect(nums, k));
	}
}
