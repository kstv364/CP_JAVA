package striverSheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {

		// sort with first indices
		// start with first
		// merge if possible
		// if not possible start afresh

		List<int[]> ans = new ArrayList<>();

		Arrays.sort(intervals, (c, b) -> c[0] - b[0]);

		int start = intervals[0][0];
		int end = intervals[0][1];

		for (int[] interval : intervals) {
			if (interval[0] <= end) {
				// merge
				end = Math.max(end, interval[1]);
			} else {
				// log
				ans.add(new int[] { start, end });
				start = interval[0];
				end = interval[1];

			}
		}
		ans.add(new int[] { start, end });
		return (int[][]) ans.toArray(new int[][] {});

	}
}
