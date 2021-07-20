package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> ans = groupAnagrams(strs);
		System.out.println(ans);
	}

	private static List<List<String>> groupAnagrams(String[] strs) {
		// TODO Auto-generated method stub

		if (strs.length == 0) {
			return new ArrayList<>();
		}

		HashMap<String, List<String>> hmap = new HashMap<String, List<String>>();
		for (String sr : strs) {
			char[] ca = sr.toCharArray();
			Arrays.sort(ca);
			String sorted = String.valueOf(ca);

			if (hmap.containsKey(sorted)) {
				hmap.get(sorted).add(sr);
			} else {
				hmap.put(sorted, new ArrayList<String>());
				hmap.get(sorted).add(sr);
			}
		}

		return new ArrayList<>(hmap.values());
	}

}
