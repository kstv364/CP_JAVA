package recursion;

public class SubsetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// subsetSum(new int[] { 1, 2, 5 }, 4);
		coinChange(new int[] { 1, 2, 5 }, 4);
	}

	private static int coinChange(int[] coins, int sum) {
		// TODO Auto-generated method stub
		int dp[][] = new int[coins.length + 1][sum + 1];
		for (int i = 0; i <= sum; i++)
			dp[0][i] = 0;
		for (int i = 0; i <= coins.length; i++)
			dp[i][0] = 1;
		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j >= coins[i - 1])
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		return dp[coins.length][sum];
	}

	private static void subsetSum(int[] arr, int k) {
		// TODO Auto-generated method stub
		// System.out.println(recur(arr, k, 0, 0));
		int n = arr.length;
		boolean dp[][] = new boolean[n + 1][k + 1];
		for (int i = 0; i <= n; i++)
			dp[i][0] = true;

		for (int i = 1; i <= k; i++)
			dp[0][i] = false;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < k + 1; j++) {
				if (j >= arr[i - 1]) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n][k]);

	}

	private static boolean recur(int[] arr, int k, int i, int psum) {
		if (psum == k)
			return true;
		if (i == arr.length)
			return false;

		return recur(arr, k, i + 1, psum + arr[i]) || recur(arr, k, i + 1, psum);
	}

}
