package SlidingWindow;

import java.util.ArrayList;

public class MaxOfSubArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ans = new ArrayList<>();
		int a[] = { 2, 3, 8, 1, 10 };
		int k = 3;
		solve(a, k, ans);
		System.out.println(ans);
	}

	private static void solve(int[] a, int k, ArrayList<Integer> ans) {
		// TODO Auto-generated method stub
		int cmx = Integer.MIN_VALUE;

		// First window
		for (int i = 0; i < k; i++) {
			cmx = max(cmx, a[i]);
		}

		ans.add(cmx);

		for (int i = 1; i + k - 1 < a.length; i++) {
			if (a[i - 1] == cmx) {
				// recalculate
				cmx = Integer.MIN_VALUE;
				for (int j = i; j <= i + k - 1; j++) {
					cmx = max(cmx, a[j]);
				}
			} else {
				cmx = max(cmx, a[i + k - 1]);
			}
			ans.add(cmx);
		}
	}

	private static int max(int a, int b) {
		// TODO Auto-generated method stub
		return a > b ? a : b;
	}

}
