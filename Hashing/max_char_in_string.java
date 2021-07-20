package Hashing;

import java.util.HashMap;

public class max_char_in_string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabbcddfffedededededddddde";
		HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();

		Character max_c = ' ';
		Integer max_f = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			if (hashmap.containsKey(s.charAt(i))) {
				Integer val = hashmap.get(s.charAt(i));
				hashmap.put(s.charAt(i), val + 1);
				if (val + 1 > max_f) {
					max_f = val + 1;
					max_c = s.charAt(i);
				}

			} else {
				hashmap.put(s.charAt(i), 1);
			}
		}
		System.out.println(max_c + "-> " + max_f);
	}

}
