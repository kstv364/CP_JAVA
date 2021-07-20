package DP;

public class lengthOfLIS {
	public int lengthOfLIS(int[] nums) {
		int dp[] = new int[nums.length];
		dp[0] = 1;
		int gmax = dp[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			gmax = Math.max(gmax, dp[i]);
		}
		return gmax;

	}
}
