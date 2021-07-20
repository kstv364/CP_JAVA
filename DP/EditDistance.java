package DP;

public class EditDistance {

	public int minDistance(String s1, String s2) {
		int n = s1.length(), m = s2.length();

		int dp[][] = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++)
			dp[i][0] = i;
		for (int i = 0; i <= m; i++)
			dp[0][i] = i;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {

				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = 1 + minof3(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]);

			}
		}
		return dp[n][m];

	}

	private int minof3(int i, int j, int k) {
		// TODO Auto-generated method stub
		return Math.min(i, Math.min(j, k));
	}
}
