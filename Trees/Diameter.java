package Trees;

import java.util.HashMap;

public class Diameter {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	private static HashMap<TreeNode, Integer> height;

	public int diameterOfBinaryTree(TreeNode root) {
		height.put(null, 0);
		getHeights(root);

		return recur(root);
	}

	private int recur(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		int dleft = recur(root.left);
		int dright = recur(root.right);

		int lheight = height.get(root.left);
		int rheight = height.get(root.right);

		return maxof3(dleft, dright, lheight + rheight + 1);

	}

	private int maxof3(int a, int b, int c) {
		return Math.max(Math.max(a, b), c);
	}

	private int getHeights(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		height.put(root, 1 + Math.max(getHeights(root.left), getHeights(root.right)));
		return height.get(root);
	}
}
