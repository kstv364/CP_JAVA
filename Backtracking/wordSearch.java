package Backtracking;

public class wordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char board[][] = { { 'e', 'a', 'g', 'h' }, { 'b', 'a', 'a', 'f' }, { 'y', 'u', 'g', 't' } };

		boolean res = WordSearch(board, "hag");
		System.out.println(res);
	}

	private static boolean WordSearch(char[][] board, String word) {
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (backtrack(board, word, 0, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean backtrack(char[][] board, String word, int curr, int i, int j) {
		// TODO Auto-generated method stub
		if (curr == word.length())
			return true;
		char[] characters = word.toCharArray();
		char letter = characters[curr];
		if (letter != board[i][j]) {
			return false;
		}
		int rowOff[] = { 0, 1, 0, -1 };
		int colOff[] = { 1, 0, -1, 0 };

		board[i][j] = '#';
		for (int d = 0; d < 4; d++) {
			if (isSafe(board, i + rowOff[d], j + colOff[d])) {
				if (backtrack(board, word, curr + 1, i + rowOff[d], j + colOff[d])) {
					return true;
				}
			}
		}
		board[i][j] = letter;
		return false;
	}

	private static boolean isSafe(char board[][], int i, int j) {
		// TODO Auto-generated method stub
		int m = board.length;
		int n = board[0].length;

		if (i < 0 || i == m || j < 0 || j == n)
			return false;
		return true;

	}

}
