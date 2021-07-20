package Trees;

import java.util.HashSet;

public class LowestCommonAncestorBT {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode lans = lowestCommonAncestor(root.left, p, q);
		TreeNode rans = lowestCommonAncestor(root.right, p, q);
		return lans != null ? (rans != null ? root : lans) : rans;
	}

	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> hset = new HashSet<>();
		for (int e : nums) {
			if (hset.contains(e))
				return true;
			hset.add(e);
		}
		return false;
	}
}
