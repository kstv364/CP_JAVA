package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	private static List<List<Integer>> ans;

	public List<List<Integer>> subsets(int[] nums) {
		ans.clear();
		recur(nums, nums.length - 1, new ArrayList<Integer>());
		return ans;
	}

	public void recur(int[] nums, int i, List<Integer> temp) {
		if (i < 0) {
			ans.add(temp);
			return;
		}
		recur(nums, i - 1, new ArrayList<Integer>(temp));
		temp.add(nums[i]);
		recur(nums, i - 1, new ArrayList<Integer>(temp));

	}
}
