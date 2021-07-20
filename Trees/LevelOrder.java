package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

	List<List<Integer>> ans = new ArrayList<List<Integer>>();

	public List<List<Integer>> levelOrder(TreeNode root) {

		if (root == null)
			return ans;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		List<Integer> temp;
		int sz;
		while (!q.isEmpty()) {
			temp = new ArrayList<>();
			sz = q.size();
			while (sz-- > 0) {
				TreeNode curr = q.poll();
				temp.add(curr.val);
				if (curr.left != null)
					q.add(curr.left);
				if (curr.right != null)
					q.add(curr.right);
			}
			ans.add(temp);
		}
		return ans;
	}
}
