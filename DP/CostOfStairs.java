package DP;

public class CostOfStairs {

	public int minCostClimbingStairs(int[] cost) {
		int n = cost.length;
		int[] costtill = new int[n];
		costtill[0] = cost[0];
		costtill[1] = cost[1];
		for (int i = 2; i < n; i++) {
			costtill[i] = cost[i] + min(costtill[i - 1], costtill[i - 2]);
		}
		return min(costtill[n - 1], costtill[n - 2]);
	}

	private static int min(int a, int b) {
		return a < b ? a : b;
	}
}
