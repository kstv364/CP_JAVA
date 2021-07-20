package DP;

public class NoOfBinStringWithNoConsecutiveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		noOfBinStringWithNoConsecutiveZeros(3);
	}

	private static int noOfBinStringWithNoConsecutiveZeros(int n) {
		// TODO Auto-generated method stub
		// ending at 0 and ending at 1
		if (n <= 1)
			return n * 2;
		// int [][]dp = new int[2][n+1];
		int zeros = 1, ones = 1;
		int nzeros = 0, nones = 0;
		for (int j = 2; j <= n; j++) {
			nzeros = zeros + ones;
			nones = zeros;

			zeros = nzeros;
			ones = nones;
		}
		return nzeros + nones;
	}

}
