package UnionFind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveChain {

	private static HashMap<Integer, Integer> parent = new HashMap<>();
	private static HashMap<Integer, Integer> size = new HashMap<>();
	private static int max = Integer.MIN_VALUE;

	public static int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		max = Integer.MIN_VALUE;
		int n = nums.length;
		parent.clear();
		size.clear();
		for (int a : nums) {
			parent.put(a, a);
			size.put(a, 1);
		}
		for (int a : nums) {
			if (set.contains(a)) {
				continue;
			}
			set.add(a);
			if (set.contains(a + 1)) {
				union(a, a + 1);
			}
			if (set.contains(a - 1)) {
				union(a, a - 1);
			}
		}
		return max;

	}

	private static void union(int i, int j) {
		// TODO Auto-generated method stub

		i = find(i);
		j = find(j);
		if (i == j)
			return;
		parent.put(j, i);
		size.put(i, size.get(i) + size.get(j));
		if (size.get(i) > max) {
			max = size.get(i);
		}

	}

	private static int find(int i) {
		if (parent.get(i) != i) {
			parent.put(i, find(parent.get(i)));
			return parent.get(i);
		}
		return i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		System.out.println(longestConsecutive(arr));

	}

}
