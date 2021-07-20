package CPGeneral;

import java.util.Arrays;

public class Shuffle {
	private int[] original;
	private int[] shuffled;

	public Shuffle(int[] nums) {
		original = Arrays.copyOf(nums, nums.length);
		shuffled = Arrays.copyOf(nums, nums.length);
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		shuffled = Arrays.copyOf(original, original.length);
		return shuffled;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int n = original.length;
		int idx = (int) (Math.random() * (n - 2));
		int t = shuffled[idx];
		shuffled[idx] = shuffled[n - 1];
		shuffled[n - 1] = t;
		return shuffled;
	}
}
