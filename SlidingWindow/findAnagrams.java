package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findAnagrams {

	public List<Integer> findAnagrams(String s, String p) {
		HashMap<Character, Integer> patternCount = new HashMap<>();
		HashMap<Character, Integer> currCount = new HashMap<>();

		List<Integer> ans = new ArrayList<Integer>();
		int pl = p.length();
		for (int i = 0; i < pl; i++) {
			patternCount.put(p.charAt(i), patternCount.getOrDefault(p.charAt(i), 0));
			currCount.put(s.charAt(i), currCount.getOrDefault(s.charAt(i), 0));
		}

		for (int i = 1; i <= s.length() - pl; i++) {
			currCount.put(s.charAt(i - 1), currCount.get(s.charAt(i - 1)) - 1);
			if (currCount.get(s.charAt(i - 1)) == 0) {
				currCount.remove(s.charAt(i - 1));
			}
			currCount.put(s.charAt(i + pl - 1), currCount.get(s.charAt(i + pl - 1)) + 1);

			if (currCount.equals(patternCount)) {
				ans.add(i);
			}
		}
		return ans;
	}

}
