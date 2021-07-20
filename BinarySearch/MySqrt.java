package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class MySqrt {

	public static boolean isPalindrome(String s) {

		s = s.toLowerCase().replaceAll("\\p{Punct}", "").replaceAll(" ", "");
		char[] arr = s.toCharArray();

		int n = arr.length;
		int i = 0, j = n - 1;
		while (i <= j) {
			if (arr[i] != arr[j])
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}

	private List<String> ans = new ArrayList<String>();

	public List<String> generateParenthesis(int n) {
		ans.clear();
		recur(n, n, "");
		return ans;

	}

	private void recur(int o, int c, String temp) {
		// TODO Auto-generated method stub
		if (o == 0 && c == 0) {
			ans.add(temp);
			return;
		}
		if (o > 0) {
			recur(o - 1, c, temp + '(');
		}
		if (c > o) {
			recur(o, c - 1, temp + ')');
		}

	}

	public int mySqrt(int x) {
		if (x == 0)
			return 0;

		int l = 1, r = Math.min(x / 2 + 1, 46340 + 10);

		int mid;
		long sqmid;
		int ans = 0;

		while (l <= r) {

			mid = l + (r - l) / 2;
			sqmid = mid * mid;

			if (sqmid == x)
				return mid;
			else if (sqmid > x) {
				r = mid - 1;
			} else {
				ans = mid;
				l = mid + 1;
			}

		}
		return ans;

	}

}
