package striverSheet;

public class NextPermutation {

	public void nextPermutation(int[] A) {
		int n = A.length;
		int i = A.length - 2;

		// THINK MOUNTAIN
		// Find first point left of peak
		// Find right point Greater than left point
		// Swap and reverse right of left point
		while (i >= 0 && A[i] >= A[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = A.length - 1;
			while (A[j] <= A[i])
				j--;
			swap(A, i, j);
		}
		reverse(A, i + 1, A.length - 1);

	}

	private void reverse(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		while (i < j) {
			swap(a, i, j);
			i++;
			j--;
		}

	}

	private void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int t = a[i];
		a[i] = a[j];
		a[j] = t;

	}

}
