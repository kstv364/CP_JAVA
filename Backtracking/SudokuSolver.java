package Backtracking;

public class SudokuSolver {

	public void solveSudoku(char[][] board) {
		recur(board, 0, 0);
	}

	private void printBoard(char[][] board) {
		int n = board.length;
		for (int i1 = 0; i1 < n; i1++) {
			for (int j1 = 0; j1 < n; j1++) {
				System.out.print(board[i1][j1] + "|");
			}
			System.out.println();
		}
	}

	private boolean recur(char[][] board, int i, int j) {
		// TODO Auto-generated method stub
		if (j == board.length) {
			j = 0;
			i++;
		}

		if (i == board.length) {
			return true;
		}

		if (board[i][j] == '.') {

			for (char num = '1'; num <= '9'; num++) {
				if (canPlace(board, i, j, num) == true) {
					board[i][j] = num;
					if (recur(board, i, j + 1) == true)
						return true; // important
					board[i][j] = '.';
				}
			}
		} else {
			return recur(board, i, j + 1);
		}
		return false;
	}

	private boolean canPlace(char[][] board, int i, int j, char num) {
		for (int r = 0; r < 9; r++) {
			if (board[r][j] == num)
				return false;
		}

		for (int r = 0; r < 9; r++) {
			if (board[i][r] == num)
				return false;
		}

		i = i / 3;
		j = j / 3;
		for (int r = i * 3; r < i * 3 + 3; r++) {
			for (int c = j * 3; c < j * 3 + 3; c++) {
				if (board[r][c] == num)
					return false;
			}
		}
		return true;
	}

}
