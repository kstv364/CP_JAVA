package Backtracking;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 10;
		char[][] board = new char[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '*';
			}
		}

		backtrack(board, 0, 0, 0, n);

	}

	private static void backtrack(char[][] board, int i, int j, int qpsf, int n) {

		if (qpsf == n) {
			// System.out.println(ans);
			System.out.println("Returniing");
			for (int i1 = 0; i1 < n; i1++) {
				for (int j1 = 0; j1 < n; j1++) {
					System.out.print(board[i1][j1] + "|");
				}
				System.out.println();
			}
			return;
		}

		if (j == n) {
			j = 0;
			i++;
		}

		if (i == n) {
			return;
		}

		// System.out.println("Called with " + i + "," + j);
		// TODO Auto-generated method stub

		// place the queen

		// check if the current queen kills any other queen
		if (isSafe(board, i, j)) {
			// recurse
			board[i][j] = '#';

			backtrack(board, i, j + 1, qpsf + 1, n);
			board[i][j] = '*';
		}
		backtrack(board, i, j + 1, qpsf, n);

	}

	private static boolean isSafe(char[][] board, int row, int col) {
		// TODO Auto-generated method stub
		int i, j;
		i = row;
		j = col - 1;

		while (j >= 0) {
			if (board[i][j] == '#')
				return false;
			j--;
		}

		i = row - 1;
		j = col - 1;

		while (j >= 0 && i >= 0) {
			if (board[i][j] == '#')
				return false;
			i--;
			j--;
		}

		i = row - 1;
		j = col;

		while (i >= 0) {
			if (board[i][j] == '#')
				return false;
			i--;
		}

		i = row - 1;
		j = col + 1;

		while (j < board.length && i >= 0) {
			if (board[i][j] == '#')
				return false;
			j++;
			i--;
		}

		return true;
	}
}
