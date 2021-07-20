package DP;

public class GoldMine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = { { 10, 33, 13, 15 }, { 22, 21, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } };
		int n = grid.length;

		int dp[][] = new int[n + 2][n];
		int path[][] = new int[n + 2][n];

		for (int i = 1; i <= n; i++) {
			dp[i][0] = grid[i - 1][0];
		}
		for (int j = 1; j < n; j++) {
			for (int i = 1; i <= n; i++) {
				int sum = 0;
				dp[i][j] = grid[i - 1][j];
				sum = max(dp[i][j - 1], dp[i - 1][j - 1], dp[i + 1][j - 1]);
				if (sum == dp[i][j - 1]) {
					path[i][j] = 2;
				} else if (sum == dp[i - 1][j - 1]) {
					path[i][j] = 3;
				} else {
					path[i][j] = 1;
				}
				dp[i][j] += sum;
			}

		}

		int max = Integer.MIN_VALUE;
		int start = -1;
		for (int i = 0; i < n + 1; i++) {
			if (dp[i][n - 1] > max) {
				max = dp[i][n - 1];
				start = i;
			}
		}
		int rowOff[] = { 1, 0, -1 };
		int colOff[] = { -1, -1, -1 };

		int i = start, j = n - 1;
		int d;
		while (n > 1) {
			d = path[i][j];
			System.out.println(d);
			i += rowOff[d - 1];
			j += colOff[d - 1];
			n--;
		}
		System.out.println(grid[i - 1][j]);
	}

	private static int max(int a, int b, int c) {
		// TODO Auto-generated method stub
		return a > b ? (a > c ? a : c) : (b > c ? b : c);
	}

}
