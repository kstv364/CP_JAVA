package DivideConquer;

public class InversionCount {

	private static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 8, 3, 2, 5, 4, 1 };
		InversionCount.count = 0;
		countInversions(a, 0, a.length - 1);
		System.out.println(InversionCount.count);
	}

	private static void countInversions(int[] a, int l, int r) {
		// TODO Auto-generated method stub
		if (l == r)
			return;
		int mid = l + (r - l) / 2;
		countInversions(a, l, mid);
		countInversions(a, mid + 1, r);
		merge(a, l, mid, r);
	}

	private static void merge(int[] a, int l, int mid, int r) {
		// TODO Auto-generated method stub
		int i = l, j = mid + 1, k = 0;
		int newArray[] = new int[r - l + 1];

		while (i <= mid && j <= r) {
			if (a[i] > a[j]) {
				InversionCount.count += (mid - i + 1);
				newArray[k++] = a[j++];
			} else {
				newArray[k++] = a[i++];
			}
		}
		while (i <= mid)
			newArray[k++] = a[i++];
		while (j <= r)
			newArray[k++] = a[j++];

		for (int e : newArray) {
			a[l++] = e;
		}

	}

}
