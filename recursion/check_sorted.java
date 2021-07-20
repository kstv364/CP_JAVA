package recursion;

public class check_sorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1, 2, 4, 4, 8 };
		System.out.println(checkSorted(a, a.length, 0));
	}

	private static boolean checkSorted(int[] a, int length, int i) {
		// TODO Auto-generated method stub
		if (i == a.length - 1) {
			return true;
		}
		if (a[i] <= a[i + 1] && checkSorted(a, length, i + 1))
			return true;
		return false;
	}

}
