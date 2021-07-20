package DP;

import java.util.Arrays;

public class LongestRepeatedSubArrayORString {
	public int findLength(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;

		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 2; j <= m; j++) {
				if (nums1[i - 1] == nums2[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][m];

	}

	public int lengthOfLIS(int[] nums) {

		int n = nums.length;
		int max = 0;
		if (n == 0)
			return max;
		int[] dp = new int[n];

		Arrays.fill(dp, 1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
				max = Math.max(max, dp[i]);
			}
		}
		return max;

	}
}
