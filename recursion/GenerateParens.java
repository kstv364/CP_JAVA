package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParens {

	static List<String> ans = new ArrayList<>();

	public static void main(String[] args) {
		generateParenthesis(3);
	}

	public static List<String> generateParenthesis(int n) {
		ans.clear();

		recur(n, n, "");
		// for (String e : ans) {
		// System.out.println(e);
		// }
		return ans;

	}

	private static void recur(int open, int close, String s) {
		// TODO Auto-generated method stub
		if (open == 0 && close == 0) {
			ans.add(s);
		}
		if (open > 0) {
			recur(open - 1, close, s + "(");
		}
		if (close > open) {
			recur(open, close - 1, s + ")");
		}
	}
}
