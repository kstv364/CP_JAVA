package DP;

public class CountPalindromicSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countPalindromicSubstrings("abaab");

	}

	private static void countPalindromicSubstrings(String string) {
		// TODO Auto-generated method stub
		int n = string.length();
		boolean palin[][] = new boolean[n][n];
		int c = 0;

		for (int i = 0; i < n; i++) {
			palin[i][i] = true;
			c++;
		}

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i <= n - l; i++) {
				int j = i + l - 1;
				if (string.charAt(i) == string.charAt(j)) {
					if (j == i + 1) {
						palin[i][j] = true;
					} else {
						palin[i][j] = palin[i + 1][j - 1];
					}
				}

				if (palin[i][j] == true) {
					c++;
				}
			}
		}
		System.out.println(c);
	}

}
