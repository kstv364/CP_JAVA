package Hashing;

import java.util.HashMap;

public class SubArraySumK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 2, 3 };
		int k = 3;
		int ans = subArraySumK(a, k);
		System.out.println(ans);

	}

	private static int subArraySumK(int[] a, int k) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> hset = new HashMap<>();
		int sum = 0;
		hset.put(0, 1);
		int count = 0;
		for (int e : a) {
			sum += e;
			if (hset.containsKey(sum - k)) {
				count += hset.get(sum - k);
			}
			hset.put(sum, hset.getOrDefault(sum, 0) + 1);

		}
		return count;
	}

}
