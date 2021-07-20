package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int e : stones) {
			pq.add(e);
		}
		int a, b;
		while (pq.size() > 1) {
			a = pq.poll();
			b = pq.poll();

			if (a != b) {
				pq.add(abs(a - b));
			}
		}
		if (pq.size() == 0)
			return 0;
		return pq.poll();
	}

	private Integer abs(int i) {
		// TODO Auto-generated method stub
		return i < 0 ? -i : i;
	}
}
