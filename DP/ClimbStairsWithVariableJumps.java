package DP;

public class ClimbStairsWithVariableJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// climbStairsWithVariableJumps(6, new int[] { 3, 3, 0, 2, 2, 3 });
		climbStairsWithVariableJumpsMin(6, new int[] { 3, 3, 0, 2, 2, 3 });

	}

	private static void climbStairsWithVariableJumpsMin(int n, int[] arr) {
		// TODO Auto-generated method stub
		Integer dp[] = new Integer[n + 1];
		dp[n] = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] > 0) {
				int min = Integer.MAX_VALUE;
				for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
					if (dp[i + j] != null) {
						min = Math.min(min, dp[i + j]);
					}
				}

				if (min != Integer.MAX_VALUE) {
					dp[i] = min + 1;
				}

			}
		}
		System.out.println(dp[1]);
	}

	private static void climbStairsWithVariableJumps(int n, int[] arr) {
		// TODO Auto-generated method stub

		int dp[] = new int[n + 1];
		dp[n] = 1;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
				dp[i] += dp[i + j];
			}
		}
		System.out.println(dp[1]);

	}

}
