package TwoPointer;

public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
		int n = nums.length;
		int j = 0;
		for (int i = 1; i < n; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[++j] = nums[i];
			}

		}
		return j + 1;

	}

	public void moveZeroes(int[] nums) {
		int j = -1;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] != 0) {
				nums[++j] = nums[i];
			}
		}
		while (++j < n) {
			nums[j] = 0;
		}

	}

	public boolean isAnagram(String s, String t) {
		int freq[] = new int[26];
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}

		for (char c : t.toCharArray()) {
			freq[c - 'a']--;
		}

		for (int e : freq) {
			if (e != 0)
				return false;
		}
		return true;
	}
}
