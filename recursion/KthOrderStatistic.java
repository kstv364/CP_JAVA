package recursion;

public class KthOrderStatistic {
	public int findKthLargest(int[] nums, int k) {

		// randomized quick select
		int n = nums.length;
		return recur(nums, 0, n - 1, n - k);
	}

	private int recur(int[] nums, int l, int r, int k) {
		// TODO Auto-generated method stub
		int mid = l + (r - l) / 2;

		while (l < r) {
			mid = partition(nums, l, r);
			if (mid == k)
				return nums[mid];
			else if (mid < k) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return nums[r];
	}

	private int partition(int[] nums, int l, int r) {

		int mid = l + (r - l) / 2;
		swap(nums, mid, r);

		int x = nums[r];
		int i = l;
		for (int j = l; j <= r - 1; j++) {
			if (nums[j] <= x) {
				swap(nums, i, j);
				i++;
			}
		}
		swap(nums, i, r);
		return i;
	}

	private void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
