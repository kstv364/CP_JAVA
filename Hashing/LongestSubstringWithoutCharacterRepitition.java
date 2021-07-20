package Hashing;

import java.util.HashMap;

public class LongestSubstringWithoutCharacterRepitition {

	private static int ans = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ans = 0;
		String input = "bbbb";
		solve(input);
		System.out.println(ans);
	}

	private static void solve(String input) {

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int curr = 0;
		for (char e : input.toCharArray()) {
			if (map.containsKey(e)) {
				// this is a repeating character
				map.clear();
				map.put(e, 1);
				curr = 1;

			} else {
				curr++;
				map.put(e, 1);
			}
			ans = max(ans, curr);
		}
	}

	private static int max(int a, int b) {
		// TODO Auto-generated method stub
		return a > b ? a : b;
	}

}
