package UnionFind;

public class UnionFind {
	private int size;
	private int numComponents; // number of connected components
	private int[] parent;
	private int[] rank;

	public UnionFind(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("Size <= 0 is not allowed");
		size = numComponents = n;
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	public int find(int p) {
		while (p != parent[p]) {
			parent[p] = parent[parent[p]]; // path compression by halving
			p = parent[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);

		// These elements are already in the same group!
		if (rootP == rootQ)
			return;

		// Merge smaller component/set into the larger one.
		if (rank[rootQ] > rank[rootP]) {
			parent[rootP] = rootQ;
		} else {
			parent[rootQ] = rootP;
			if (rank[rootP] == rank[rootQ]) {
				rank[rootP]++;
			}
		}

		// Since the roots found are different we know that the number of
		// components/sets has decreased by one
		numComponents--;
	}

	// Return whether or not the elements 'p' and 'q' are in the same
	// components/set.
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	// Returns the number of remaining components/sets
	public int components() {
		return numComponents;
	}

	// Return the number of elements in this UnionFind/Disjoint set
	public int size() {
		return size;
	}
}
