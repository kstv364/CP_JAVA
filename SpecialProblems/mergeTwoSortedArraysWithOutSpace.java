package SpecialProblems;

public class mergeTwoSortedArraysWithOutSpace {

	public static void merge(long arr1[], long arr2[], int n, int m) {
		int i = 0, j = 0;
		while (i < n && j < m) {
			if (arr1[i] <= arr2[j]) {
				i++;
			} else {
				swap(arr1, arr2, i, j);
				long temp = arr2[0];
				int k = 1;
				while (k < m && arr2[k] < temp) {
					arr2[k - 1] = arr2[k];
					k++;
				}
				arr2[k - 1] = temp;
			}
		}

	}

	private static void swap(long arr1[], long arr2[], int i, int j) {
		long temp = arr1[i];
		arr1[i] = arr2[j];
		arr2[j] = temp;
	}
}
