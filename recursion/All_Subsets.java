package recursion;

public class All_Subsets {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3 };
		printAllSubsets(a, 0, "");

	}

	private static void printAllSubsets(int[] a, int i, String out) {
		// TODO Auto-generated method stub
		if (i == a.length) {
			System.out.println('[' + out + ']');
			return;
		}
		printAllSubsets(a, i + 1, out);
		printAllSubsets(a, i + 1, out + a[i]);
	}
}
