package DP;

public class LongestBitonicSequence {

	public int minimumMountainRemovals(int[] nums) {
		int n = nums.length;
		int lis[] = new int[n];
		int lds[] = new int[n];

		lis[0] = 1;
		lds[n - 1] = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					lis[i] = Math.max(lis[i], 1 + lis[j]);
				}
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (nums[i] > nums[j]) {
					lds[i] = Math.max(lds[i], 1 + lds[j]);
				}
			}
		}
		int max = lis[0] + lds[0] - 1;
		for (int i = 1; i < n; i++) {
			max = Math.max(max, lis[i] + lds[i] - 1);
		}
		return n - max;
	}

}
