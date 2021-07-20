package Heaps;

import java.util.PriorityQueue;

public class KthLargestInStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 7, k = 3;
		int a[] = { 33, 10, 25, 178, 3, 192, 200 };
		solve(a, n, k);
	}

	private static void solve(int[] a, int n, int k) {
		PriorityQueue<Integer> mh = new PriorityQueue<>();
		for (int e : a) {
			mh.add(e);
			int sz = mh.size();
			if (sz < k) {
				System.out.println("#");
			} else {
				if (sz > k) {
					mh.poll();
				}
				System.out.println(mh.peek());
			}
		}

	}

}
