package DP;

import java.util.HashMap;

// 		FACEBOOK
public class SubArraySum {
	public int subarraySum(int[] arr, int k) {
		int n = arr.length;
		HashMap<Integer, Integer> dp = new HashMap<>();
		int sum = 0, count = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == k)
				count++;
			if (dp.containsKey(sum - k))
				count += dp.get(sum - k);
			dp.put(sum, dp.getOrDefault(sum, 0) + 1);
		}
		return count;

	}
}
