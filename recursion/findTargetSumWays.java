package recursion;

public class findTargetSumWays {

	public static int findTargetSumWays(int[] nums, int target) {
		return recur(nums, target, 0, 0);
	}

	private static int recur(int[] nums, int target, int i, int cursum) {
		// TODO Auto-generated method stub
		if (i == nums.length && cursum == target)
			return 1;
		else if (i == nums.length)
			return 0;
		return recur(nums, target, i + 1, cursum + nums[i]) + recur(nums, target, i + 1, cursum - nums[i]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
	}

}
