package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdbcmdca";
		System.out.println(solve(s));
	}

	private static int solve(String s) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> nonrepeat = new HashMap<>();
		HashSet<Character> repeat = new HashSet<>();
		char a[] = s.toCharArray();

		for (int i = 0; i < a.length; i++) {
			if (nonrepeat.containsKey(a[i])) {
				repeat.add(a[i]);
			} else {
				nonrepeat.put(a[i], i);
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (!repeat.contains(a[i])) {
				return i;
			}
		}
		return -1;

	}

}
