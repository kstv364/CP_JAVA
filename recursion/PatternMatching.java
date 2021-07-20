package recursion;

public class PatternMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "baaabab";

		PatternMatching(s, "**ba**ab");
		PatternMatching(s, "baaa?ab");
		PatternMatching(s, "ba*ab?b");
		PatternMatching(s, "*a*ba******");

	}

	private static void PatternMatching(String s, String t) {
		// TODO Auto-generated method stub
		// System.out.println(recur(s, t, 0, 0));
		int n = t.length(), m = s.length();
		boolean dp[][] = new boolean[n + 1][m + 1];

		for (int i = n; i >= 0; i--) {
			for (int j = m; j >= 0; j--) {

				if (i == n && j == m)
					dp[i][j] = true;
				else if (i == n)
					dp[i][j] = false;
				else if (j == m) {
					if (t.charAt(i) == '*')
						dp[i][j] = dp[i + 1][j];
					else
						dp[i][j] = false;

				} else {
					if (t.charAt(i) == '?')
						dp[i][j] = dp[i + 1][j + 1];
					else if (t.charAt(i) == s.charAt(j))
						dp[i][j] = dp[i + 1][j + 1];
					else if (t.charAt(i) == '*') {
						dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
					}
				}
			}
		}
		System.out.println(dp[0][0]);

	}

	private static boolean recur(String s, String t, int i, int j) {
		if (i == s.length() && j == t.length())
			return true;
		// TODO Auto-generated method stub
		if (i >= s.length() || j >= t.length())
			return false;
		if (t.charAt(j) == '?') {
			return recur(s, t, i + 1, j + 1);
		}
		if (t.charAt(j) == '*') {
			return recur(s, t, i + 1, j + 1) || recur(s, t, i + 1, j);
		}
		if (t.charAt(j) == s.charAt(i)) {
			return recur(s, t, i + 1, j + 1);
		}
		return false;
	}

}
