package Graph;

public class MaxAreaOfIsland {
	public int maxAreaOfIsland(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		int ans = 0;

		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && grid[i][j] == 1) {
					Integer currmax = 0;
					dfs(grid, visited, i, j, currmax);
					ans = Math.max(ans, currmax);
				}
			}
		}
		return ans;

	}

	private void dfs(int[][] grid, boolean[][] visited, int i, int j, Integer currmax) {
		// TODO Auto-generated method stub
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == true || grid[i][j] == 0)
			return;

		visited[i][j] = true;
		currmax++;

		int dx[] = { 0, 1, 0, -1 };
		int dy[] = { 1, 0, -1, 0 };
		for (int d = 0; d < 4; d++) {
			dfs(grid, visited, i + dx[d], j + dy[d], currmax);
		}

	}
}
