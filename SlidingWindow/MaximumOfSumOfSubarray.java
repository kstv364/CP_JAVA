
package SlidingWindow;

public class MaximumOfSumOfSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 2, 6, 1 };
		solve(a);
	}

	private static void solve(int[] a) {
		// TODO Auto-generated method stub
		int i, j;
		int n = a.length;
		int sum = 0;
		for (int k = 1; k <= n; k++) {
			i = 0;
			j = i + k - 1;
			int csum = 0;
			for (int c = i; c <= j; c++) {
				csum += a[c];
			}
			sum += csum;

			for (i = 1; i + k - 1 < n; i++) {
				csum += a[i + k - 1] - a[i - 1];
				sum += csum;
			}
		}
		System.out.println(sum);
	}

}
