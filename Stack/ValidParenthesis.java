package Stack;

import java.util.Stack;

public class ValidParenthesis {
	public boolean isValid(String s) {
		int n = s.length();

		Stack<Character> st = new Stack<>();
		for (int i = 0; i < n; i++) {

			if (s.charAt(i) == '[') {
				st.push(']');
			} else if (s.charAt(i) == '(') {
				st.push(')');
			} else if (s.charAt(i) == '{') {
				st.push('}');
			} else {
				if (st.empty())
					return false;
				if (st.peek() == s.charAt(i)) {
					st.pop();
				} else
					return false;
			}
		}
		if (!st.empty())
			return false;
		return true;
	}
}
