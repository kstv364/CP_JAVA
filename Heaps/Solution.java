package Heaps;

import java.util.PriorityQueue;

class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				pq.add(matrix[i][j]);
			}
		}
		k--;
		while (k-- > 0) {
			pq.poll();
		}

		return pq.peek();
	}

}