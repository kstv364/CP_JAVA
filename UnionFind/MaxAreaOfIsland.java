package UnionFind;

public class MaxAreaOfIsland {

	private static int maxSize = 0;

	public static int maxAreaOfIsland(int[][] grid) {
		int m = grid.length, n = grid[0].length;

		int parent[] = new int[m * n];
		int size[] = new int[m * n];

		maxSize = 0;

		for (int i = 0; i < m * n; i++) {
			parent[i] = i;
			size[i] = 1;
		}

		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, -1, 0, 1 };

		int ni, nj;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (grid[i][j] == 1) {
					maxSize = maxSize > 0 ? maxSize : 1;
				}

				for (int d = 0; d < 4; d++) {
					ni = i + dx[d];
					nj = j + dy[d];

					if (isSafe(ni, nj, m, n) && grid[i][j] == 1 && grid[ni][nj] == 1) {
						union(parent, size, calIndex(i, j, n), calIndex(ni, nj, n));
					}
				}

			}
		}
		return maxSize;
	}

	private static void union(int[] parent, int[] size, int i, int j) {
		// TODO Auto-generated method stub
		// System.out.println();
		i = find(parent, i);
		j = find(parent, j);
		if (i == j)
			return;
		parent[j] = i;
		size[i] += size[j];
		if (size[i] > maxSize) {
			maxSize = size[i];
		}

	}

	private static int find(int[] parent, int i) {
		// System.out.println(parent[i] + "," + i);
		if (parent[i] != i)
			return parent[i] = find(parent, parent[i]);
		return i;
	}

	private static boolean isSafe(int i, int j, int m, int n) {
		// TODO Auto-generated method stub
		return i >= 0 && j >= 0 && i < m && j < n;
	}

	private static int calIndex(int i, int j, int n) {
		return i * n + j;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 0, 1, 0 }, { 1, 1, 0, 0 }, { 1, 0, 1, 0 }, { 1, 0, 0, 1 } };

		System.out.println(maxAreaOfIsland(grid));
	}
}
