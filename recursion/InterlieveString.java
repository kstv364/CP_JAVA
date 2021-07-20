package recursion;

import java.util.Arrays;

public class InterlieveString {

	private static int state[][];

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
			return true;

		state = new int[s1.length()][s2.length()];
		for (int[] row : state)
			Arrays.fill(row, -1);
		return recur(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0) == 1 ? true : false;
	}

	int check(char[] s1, char[] s2, int i, int j) {
		if (s1.length == i) {
			return 1;
		}
		if (s1[i] == s2[j])
			return check(s1, s2, i + 1, j + 1);
		return 0;
	}

	int recur(char[] s1, char[] s2, char[] s3, int i, int j, int k) {

		if (s1.length + s2.length != s3.length)
			return 0;

		if (state[i][j] != -1)
			return state[i][j];

		if (i == s1.length && j == s2.length && k == s3.length) {
			return state[i][j] = 1;

		}

		if (i == s1.length) {
			return check(s2, s3, j, k);
		}

		if (j == s2.length) {
			return check(s1, s3, i, k);
		}

		if (s1[i] == s3[k] && s2[j] != s3[k]) {

			return state[i][j] = recur(s1, s2, s3, i + 1, j, k + 1);
		}

		if (s1[i] != s3[k] && s2[j] == s3[k]) {
			return state[i][j] = recur(s1, s2, s3, i, j + 1, k + 1);
		}

		if (s1[i] == s3[k] && s2[j] == s3[k]) {
			return state[i][j] = ((recur(s1, s2, s3, i, j + 1, k + 1) == 1)
					|| (recur(s1, s2, s3, i + 1, j, k + 1) == 1)) == true ? 1 : 0;
		}
		return state[i][j] = 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
