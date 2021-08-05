package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CPGeneral {
	private static int ans = 0;

	public int sumEvenGrandparent(TreeNode root) {
		ans = 0;
		preorder(root);
		return ans;
	}

	private static void preorder(TreeNode root) {
		// TODO Auto-generated method stub
		if (root != null) {
			addGrandChild(root);
			preorder(root.left);
			preorder(root.right);
		}
	}

	private static void addGrandChild(TreeNode root) {
		// TODO Auto-generated method stub
		if (root.val % 2 == 1)
			return;

		if (root.left != null) {
			addIfNotNull(root.left.left);
			addIfNotNull(root.left.right);
		}

		if (root.right != null) {
			addIfNotNull(root.right.left);
			addIfNotNull(root.right.right);
		}
	}

	private static void addIfNotNull(TreeNode root) {
		// TODO Auto-generated method stub
		if (root != null) {
			ans += root.val;
		}
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		int n = nums.length;
		return buildTree(nums, 0, n - 1);
	}

	private TreeNode buildTree(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		if (j < i)
			return null;
		int mid = i + (j - i) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildTree(nums, i, mid - 1);
		root.right = buildTree(nums, mid, j);
		return root;

	}

	public int findIntegers(int n) {

		int l = findBits(n);
		int dp[][] = new int[2][l + 1];
		for (int i = 1; i <= l; i++) {
			dp[0][i] = dp[0][i - 1] + dp[1][i - 1];
			dp[1][i] = dp[0][i - 1];
		}

		return dp[0][l] + dp[1][l];

	}

	private int findBits(int n) {
		// TODO Auto-generated method stub
		int c = 0;
		while (n > 0) {
			n = n >> 1;
			c++;
		}
		return c;
	}

	public boolean isValidBST(TreeNode root) {

		return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValid(TreeNode root, int minValue, int maxValue) {
		// TODO Auto-generated method stub
		if (root == null)
			return true;

		if (root.val <= minValue || root.val >= maxValue)
			return false;
		boolean left = isValid(root.left, minValue, root.val);
		boolean right = isValid(root.right, root.val, maxValue);

		return left && right;
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		int lh = getHeight(root.left);
		int rh = getHeight(root.right);

		if (Math.abs(lh - rh) > 1)
			return false;
		boolean lb = isBalanced(root.left);
		boolean rb = isBalanced(root.right);

		return lb && rb;

	}

	private int getHeight(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	public List<List<String>> groupAnagrams(String[] strs) {

		HashMap<String, List<String>> hmap = new HashMap<>();
		for (String s : strs) {
			String normal = getCount(s);
			List<String> tmp = hmap.getOrDefault(normal, new ArrayList<String>());
			tmp.add(s);
			hmap.put(normal, tmp);
		}
		List<List<String>> ans = new ArrayList<>();
		for (Map.Entry<String, List<String>> e : hmap.entrySet()) {
			ans.add(e.getValue());
		}
		return ans;
	}

	private String getCount(String s) {
		// TODO Auto-generated method stub
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (count[i] > 0) {
				sb.append((char) ('a' + i)).append(count[i]);
			}
		}
		return sb.toString();
	}

	public int[] searchRange(int[] nums, int target) {
		int l = 0, h = nums.length - 1;
		int found = -1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (nums[mid] == target) {
				found = mid;
			} else if (nums[mid] < target) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		int s = -1, f = -1;
		if (found > 0) {
			s = found;
			while (s > 0 && nums[s - 1] == target) {
				s--;
			}

			f = found;
			while (f < nums.length && nums[f + 1] == target) {
				f++;
			}

			return new int[] { s, f };
		}

		return new int[] { -1, -1 };
	}

	public String shortestPalindrome(String s) {
		// find first lps
		// add extra characters
		int cl = 1;
		for (int l = 1; l <= s.length(); l++) {
			boolean ispalin = isPalindrome(s, 0, l - 1);
			if (ispalin) {
				cl = l;
			}
		}
		String rest = "";
		if (cl < s.length()) {
			rest = s.substring(cl);
		}
		return reverse(rest) + s;

	}

	private String reverse(String rest) {
		// TODO Auto-generated method stub
		char[] os = rest.toCharArray();
		int i = 0, j = rest.length() - 1;
		while (i < j) {
			char t = os[i];
			os[i] = os[j];
			os[j] = t;
			i++;
			j--;
		}
		return String.valueOf(os);
	}

	private boolean isPalindrome(String s, int i, int j) {
		// TODO Auto-generated method stub
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public String removeDuplicateLetters(String s) {
		int freq[] = new int[26];
		for (char ch : s.toCharArray()) {
			if (freq[ch - 'a'] == 0) {
				freq[ch - 'a'] = 1;
			}

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (freq[i] > 0) {
				sb.append((char) ('a' + i));
			}
		}
		return sb.toString();
	}

	public int[] finalPrices(int[] prices) {
		int n = prices.length;

		int next[] = new int[n];
		Stack<Integer> st = new Stack<>();
		for (int i = n - 2; i >= 0; i--) {
			while (!st.empty() && st.peek() >= prices[i]) {
				st.pop();
			}

			if (st.empty()) {
				next[i] = 0;
			} else {
				next[i] = st.peek();
			}
			st.push(prices[i]);
			prices[i] -= next[i];
		}
		return prices;

	}

	public int maxArea(int[] height) {

		int n = height.length;
		int l = 0, r = n - 1;
		int ans = 0;
		while (l < r) {
			int area = (r - l + 1) * Math.min(height[r], height[l]);
			ans = Math.max(area, ans);

			if (height[r] > height[l])
				l++;
			else
				r--;
		}
		return ans;
	}

}
