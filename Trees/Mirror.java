package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Mirror {

	public boolean isSymmetric(TreeNode root) {
		return recur(root.left, root.right);

	}

	public boolean recur(TreeNode r1, TreeNode r2) {
		if (r1 == null)
			return r2 == null ? true : false;

		if (r1.val != r2.val)
			return false;
		return recur(r1.left, r2.right) && recur(r1.right, r2.left);
	}

	public List<List<Integer>> levelOrder(Node root) {

		List<List<Integer>> ans = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();

		if (root == null)
			return ans;
		List<Integer> temp;
		q.offer(root);
		Node curr;
		while (!q.isEmpty()) {
			int size = q.size();
			temp = new ArrayList<>();
			while (size-- > 0) {
				curr = q.poll();
				temp.add(curr.val);
				for (Node n : curr.children) {
					q.offer(n);

				}
			}
			ans.add(temp);
		}
		return ans;
	}

	public boolean isBipartite(int[][] graph) {

		int n = graph.length;
		int[] color = new int[n];
		int[] visited = new int[n];

		for (int i = 0; i < n; i++) {
			if (color[i] == 0)
				if (isBipartiteUtil(graph, color, i) == false)
					return false;
		}

		return true;
	}

	public boolean isBipartiteUtil(int[][] graph, int[] color, int src) {
		Queue<Integer> q = new LinkedList<>();
		color[src] = 1;
		q.add(src);

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int e : graph[curr]) {
				if (color[e] == 0) {
					color[e] = color[curr] == 1 ? 2 : 1;
					q.offer(e);
				} else {
					if (color[e] == color[curr])
						return false;
				}
			}
		}

		return true;
	}

}
