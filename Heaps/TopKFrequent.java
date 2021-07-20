package Heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

	public int[] topKFrequent(int[] nums, int k) {

		HashMap<Integer, Integer> freq = new HashMap<>();
		for (int e : nums) {
			freq.put(e, freq.getOrDefault(e, 0) + 1);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				// TODO Auto-generated method stub
				if (freq.get(a) < freq.get(b))
					return 1;
				else if (freq.get(a) > freq.get(b))
					return -1;
				return 0;
			}
		});
		for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
			pq.add(e.getKey());
			if (pq.size() > k)
				pq.poll();
		}
		int[] ans = new int[k];
		int j = 0;
		while (!pq.isEmpty()) {
			ans[j++] = pq.poll();
		}
		return ans;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
