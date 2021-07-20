package Interview;

public class Solution<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "abcde";
		printPattern(input);

		input = "one two three";
		System.out.println(reverseZoho(input, 0));

		input = "a12b8c13";
		decode(input);

		String a = "abcdefghi";
		String b = "desf";
		int ans = checkSubtring(a, b);
		System.out.println(ans);

	}

	private static int checkSubtring(String a, String b) {
		// TODO Auto-generated method stub
		int l = b.length();
		int hash = b.hashCode();
		String sub;
		for (int i = 0; i <= a.length() - l; i++) {
			sub = a.substring(i, i + l);
			int candidate = sub.hashCode();
			if (candidate == hash) {
				if (sub.compareTo(b) == 0) {
					return i;
				}
			}
		}
		return -1;
	}

	private static void decode(String input) {
		// TODO Auto-generated method stub
		char c;
		String ans = "";
		for (int i = 0; i < input.length(); i++) {
			if (Character.isAlphabetic(input.charAt(i))) {
				int j = i + 1;
				int num = 0;
				while (j < input.length() && Character.isDigit(input.charAt(j))) {
					num = num * 10 + (input.charAt(j) - '0');
					j++;
				}
				while (num > 0) {
					ans += input.charAt(i);
					num--;
				}
				i = j - 1;
			}
		}
		System.out.println(ans);

	}

	public static <T> void printArray(T arr[]) {
		for (T e : arr) {
			System.out.print(e);
		}
		System.out.println();
	}

	private static String reverseZoho(String input, int start) {
		// TODO Auto-generated method stub
		int i = 0;
		String out = "";
		for (i = start; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				break;
			} else {
				out += input.charAt(i);
			}
		}
		String returned = "";
		if (i != input.length()) {
			returned = reverseZoho(input, i + 1);
		}
		returned += out + " ";
		return returned;

	}

	private static void printPattern(String input) {
		// TODO Auto-generated method stub
		int n = input.length();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j || (i + j) == n + 1) {
					System.out.print(input.charAt(j - 1));
				} else {
					System.out.print(" ");
				}

			}
			System.out.println();
		}
	}

}
