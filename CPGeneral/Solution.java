package CPGeneral;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class Solution {
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);

		int hmax = findMaxDifference(horizontalCuts, h);
		int wmax = findMaxDifference(verticalCuts, w);

		return hmax * wmax;
	}

	public void rotate(int[][] arr) {
		int n = arr.length;
		int temp;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}

		int i = 0, j = n - 1;
		while (i < j) {
			for (int c = 0; c < n; c++) {
				temp = arr[c][i];
				arr[c][i] = arr[c][j];
				arr[c][j] = temp;
			}

			i++;
			j--;
		}

	}

	private int findMaxDifference(int[] horizontalCuts, int h) {
		// TODO Auto-generated method stub
		int diff = 0;
		for (int i = 1; i < horizontalCuts.length; i++) {
			diff = max(diff, horizontalCuts[i] - horizontalCuts[i - 1]);
		}

		diff = max(diff, horizontalCuts[0]);
		diff = max(diff, h - horizontalCuts[horizontalCuts.length - 1]);
		return diff;
	}

	private int max(int a, int b) {
		// TODO Auto-generated method stub
		return a > b ? a : b;
	}

	public List<List<Integer>> groupThePeople(int[] groupSizes) {

		List<List<Integer>> ans = new ArrayList<>();
		HashMap<Integer, List<Integer>> hmap = new HashMap<>();
		for (int i = 0; i < groupSizes.length; i++) {
			List<Integer> temp = hmap.getOrDefault(groupSizes[i], new ArrayList<>());
			if (temp.size() == groupSizes[i]) {
				ans.add(temp);
				temp.clear();
			}
			temp.add(i);
			hmap.put(groupSizes[i], temp);
		}
		for (Map.Entry<Integer, List<Integer>> entry : hmap.entrySet()) {
			ans.add(entry.getValue());
		}
		return ans;
	}

	public void solve(char[][] board) {
		int n = board.length, m = board[0].length;
		boolean visited[][] = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			if (!visited[i][0] == true) {
				dfs(visited, board, false, i, 0);
			}
			if (!visited[0][i] == true) {
				dfs(visited, board, false, 0, i);
			}
			if (!visited[i][m - 1] == true) {
				dfs(visited, board, false, i, m - 1);
			}
			if (!visited[n - 1][i] == true) {
				dfs(visited, board, false, n - 1, i);
			}
		}

		// all edge 0 are marked
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < m - 1; j++) {
				if (board[i][j] == 'O') {
					dfs(visited, board, true, i, j);
				}
			}
		}

	}

	private void dfs(boolean[][] visited, char[][] board, boolean mark, int r, int c) {
		// TODO Auto-generated method stub
		int n = board.length, m = board[0].length;
		if (r >= n || c >= m || r < 0 || c < 0 || board[r][c] == 'X' || visited[r][c] == true)
			return;
		visited[r][c] = true;
		if (mark == true)
			board[r][c] = 'X';
		int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
		for (int[] d : dir) {
			dfs(visited, board, mark, r + d[0], c + d[1]);
		}
	}

	public boolean canMeasureWater(int j1, int j2, int tc) {
		if (tc > j1 + j2)
			return false;
		return tc % (gcd(j1, j2)) == 0;
	}

	private int gcd(int j1, int j2) {
		// TODO Auto-generated method stub
		if (j2 == 0)
			return j1;
		return gcd(j2, j1 % j2);
	}

	public int jump(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				for (int j = Math.min(i + nums[i], n); j > i; j--) {
					dp[j] = Math.min(dp[j], 1 + dp[i]);
				}
			}
		}
		return dp[n - 1];
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int n = obstacleGrid.length, m = obstacleGrid[0].length;
		int[][] dp = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				} else {
					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
					}
				}

			}
		}

		return dp[n - 1][m - 1];

	}

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

	public int rangeSum(int[] nums, int n, int left, int right) {

		int MOD = 10 ^ 9 + 7;

		for (int i = 1; i < n; i++) {
			nums[i] += (nums[i - 1]) % MOD;
		}

		int mod = 10 ^ 9 + 7;

		int N = n * (n + 1) / 2;
		long newArr[] = new long[N];

		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (i == 0) {
					newArr[k++] = nums[j];
				} else {
					newArr[k++] = nums[j] - nums[i - 1];
				}

			}
		}

		Arrays.sort(newArr);
		for (long e : newArr) {
			System.out.print(e + ",");
		}
		System.out.println();
		for (int i = 1; i < n; i++) {
			newArr[i] += (newArr[i - 1]) % MOD;
		}

		if (left == 1) {
			return (int) newArr[right - 1];
		} else {
			return (int) (newArr[right - 1] - newArr[left - 2]);
		}

	}

	public boolean isValidSudoku(char[][] board) {
		int n = board.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] != '.') {
					if (check(board, i, j) == false) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private boolean check(char[][] board, int i, int j) {
		// TODO Auto-generated method stub
		char num = board[i][j];
		int n = board.length;

		for (int r = 0; r < n; r++) {
			if (board[r][j] == num && r != i)
				return false;

			if (board[i][r] == num && r != j)
				return false;
		}

		int ni = i / 3;
		int nj = j / 3;

		for (int r = ni * 3; r < ni * 3 + 3; r++) {
			for (int c = nj * 3; c < nj * 3 + 3; c++) {
				if (board[r][c] == num && r != i && c != j)
					return false;
			}
		}
		return true;
	}

	public int[] avoidFlood(int[] rains) {
		int n = rains.length;
		int ans[] = new int[n];
		HashMap<Integer, Integer> hmap = new HashMap<>();
		Queue<Integer> list = new LinkedList();
		int nzeroes = 0;
		for (int i = 0; i < n; i++) {
			int e = rains[i];
			if (e == 0) {
				nzeroes++;
			} else {
				if (hmap.containsKey(e)) {
					if (nzeroes > 0) {
						hmap.remove(e);
						list.add(e);
						nzeroes--;
						ans[i] = e;
					} else {
						return new int[] {};
					}

				}
				hmap.put(e, 1);
			}
		}
		for (int i = 0; i < n; i++) {
			if (ans[i] == 0) {
				if (!list.isEmpty()) {
					ans[i] = list.poll();
				} else {
					ans[i] = 1;
				}
			}
		}
		return ans;

	}

	private boolean possible(int[] rains, int i, int[] ans, HashSet<Integer> hset) {
		// TODO Auto-generated method stub
		if (i == rains.length)
			return true;
		if (rains[i] > 0) {
			ans[i] = -1;
			if (hset.contains(rains[i])) {
				return false;
			}
			hset.add(rains[i]);

			if (possible(rains, i + 1, ans, hset)) {
				return true;
			} else {
				hset.remove(rains[i]);
				return false;
			}

		} else {
			if (hset.isEmpty() == false) {

				HashSet<Integer> clone = (HashSet<Integer>) hset.clone();
				for (Integer e : clone) {
					int temp = e;
					hset.remove(temp);
					ans[i] = temp;
					if (possible(rains, i + 1, ans, hset) == true) {
						return true;
					}
					hset.add(temp);
				}
				return false;
			} else {
				ans[i] = 1;
				return possible(rains, i + 1, ans, hset);
			}

		}
	}

	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(a, b) -> (a[0] * a[0] + a[1] * a[1]) - ((b[0] * b[0] + b[1] * b[1])));
		for (int i = 0; i < points.length; i++) {
			pq.add(points[i]);
		}

		int[][] ans = new int[k][2];
		int i = 0;
		while (i < k) {
			ans[i] = pq.poll();
			i++;
		}
		return ans;

	}

	public String removeDuplicates(String s, int k) {
		Stack<CharFreq> st = new Stack<>();
		for (char c : s.toCharArray()) {
			if (st.empty()) {
				st.push(new CharFreq(c, 1));
			} else {
				if (st.peek().c == c) {
					int prevf = st.pop().f;
					if (prevf == k - 1) {
						continue;
					}
					st.push(new CharFreq(c, prevf + 1));
				} else {
					st.push(new CharFreq(c, 1));
				}
			}
		}
		StringBuilder ans = new StringBuilder();
		while (!st.empty()) {
			CharFreq curr = st.peek();
			int f = curr.f;
			while (f-- > 0) {
				ans.append(curr.c);
			}
			st.pop();
		}
		ans.reverse();
		return ans.toString();
	}

	class CharFreq {
		char c;
		int f;

		CharFreq(char c, int f) {
			this.c = c;
			this.f = f;
		}

	}

}
