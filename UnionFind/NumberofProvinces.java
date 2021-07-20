package UnionFind;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class NumberofProvinces {

	public int longestConsecutive(int[] nums) {
		int n = nums.length;
		int[] parent = new int[n];
		Integer[] size = new Integer[n];
		for (int i = 0; i < n; i++)
			parent[i] = i;

		HashSet<Integer> hset = new HashSet<>();
		for (int e : nums) {

			if (hset.contains(e - 1)) {
				union(parent, size, e, e - 1);
			}
			if (hset.contains(e + 1)) {
				union(parent, size, e, e + 1);
			}
			hset.add(e);
		}

		return Collections.max(Arrays.asList(size));
	}

	public void union(int[] parent, Integer[] size, int a, int b) {
		a = find(parent, a);
		b = find(parent, b);
		if (a == b)
			return;
		parent[b] = a;
		size[a] += size[b];
	}

	int find(int[] parent, int a) {
		if (parent[a] != a)
			return parent[a] = find(parent, parent[a]);
		return a;
	}
}
