package Heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class kClosest {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		int n = arr.length;

		List<Integer> ans = new ArrayList<Integer>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < k; i++) {
			pq.add(arr[i] - x);
		}

		for (int i = k; i < n; i++) {
			if (Math.abs(pq.peek()) > Math.abs(arr[i] - x)) {
				pq.poll();
				pq.add(arr[i] - x);
			}

		}

		while (k-- > 0) {
			ans.add(pq.poll() + x);
		}
		return ans;

	}

	public int minSetSize(int[] arr) {
		TreeMap<Integer, Integer> tmap = new TreeMap<>();
		int n = arr.length, curr = arr.length;
		for (int e : arr) {
			tmap.put(e, tmap.getOrDefault(e, 0) + 1);
		}
		int ans = 0;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> tmap.get(b) - tmap.get(a));
		maxHeap.addAll(tmap.keySet());

		while (curr > n / 2) {
			int key = maxHeap.poll();
			curr -= tmap.get(key);
			ans++;
		}
		return ans;

	}

}
