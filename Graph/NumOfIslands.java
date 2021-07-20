package Graph;

public class NumOfIslands {
	public int numIslands(char[][] grid) {
		int n = grid.length, m = grid[0].length;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == false && grid[i][j] == '1') {
					ans++;
					dfs(grid, visited, i, j);
				}
			}
		}
		return ans;
	}

	private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
		// TODO Auto-generated method stub
		int n = grid.length, m = grid[0].length;
		if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j] == true || grid[i][j] == '0')
			return;

		visited[i][j] = true;
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			dfs(grid, visited, nx, ny);

		}
	}
}
