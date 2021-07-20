package DP;

public class MinCostMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// minCostMatrix(3, 3, new int[][] { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3
		// } });
		goldMiner(3, 3, new int[][] { { 1, 3, 3 }, { 2, 1, 4 }, { 0, 6, 4 } });

	}

	private static void goldMiner(int n, int m, int[][] arr) {
		int dp[][] = new int[n + 2][m];
		// base case
		for (int i = 1; i < n + 1; i++) {
			dp[i][0] = arr[i - 1][0];
		}
		for (int j = 1; j < m; j++) {
			for (int i = 1; i < n + 1; i++) {
				dp[i][j] = arr[i - 1][j] + Math.max(dp[i - 1][j - 1], Math.max(dp[i][j - 1], dp[i + 1][j - 1]));
			}
		}
		int ans = Integer.MIN_VALUE;
		for (int i = 1; i < n + 1; i++) {
			ans = Math.max(ans, dp[i][m - 1]);
		}
		System.out.println(ans);
	}

	private static void minCostMatrix(int n, int m, int[][] grid) {
		// TODO Auto-generated method stub
		int[][] dp = new int[n][m];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < n; i++) {
			dp[i][0] = grid[i][0] + dp[i - 1][0];
			dp[0][i] = grid[0][i] + dp[0][i - 1];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		System.out.println(dp[n - 1][m - 1]);
	}

}
