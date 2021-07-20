package Hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class intersection_of_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1[] = { 1, 2, 2, 1 };
		int a2[] = { 4, 6, 2, 2, 1 };

		findIntersection(a1, a2);

	}

	private static void findIntersection(int[] a1, int[] a2) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> hmap = new HashMap<>();
		for (int e : a1) {
			if (hmap.containsKey(e)) {
				hmap.put(e, hmap.get(e) + 1);
			} else {
				hmap.put(e, 1);
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for (int e : a2) {
			if (hmap.containsKey(e)) {
				ans.add(e);
				hmap.put(e, hmap.get(e) - 1);
				if (hmap.get(e) == 0) {
					hmap.remove(e);
				}
			}
		}
		int[] arr = new int[ans.size()];
		int i = 0;
		for (Integer e : ans) {
			arr[i] = e;
			i++;
		}
		display(arr);
	}

	private static void display(int[] arr) {
		// TODO Auto-generated method stub
		for (int e : arr) {
			System.out.print(e + ",");
		}
		System.out.println();
	}

}
