package Trees;

public class CPGeneral {
	private static int ans = 0;

	public int sumEvenGrandparent(TreeNode root) {
		ans = 0;
		preorder(root);
		return ans;
	}

	private static void preorder(TreeNode root) {
		// TODO Auto-generated method stub
		if (root != null) {
			addGrandChild(root);
			preorder(root.left);
			preorder(root.right);
		}
	}

	private static void addGrandChild(TreeNode root) {
		// TODO Auto-generated method stub
		if (root.val % 2 == 1)
			return;

		if (root.left != null) {
			addIfNotNull(root.left.left);
			addIfNotNull(root.left.right);
		}

		if (root.right != null) {
			addIfNotNull(root.right.left);
			addIfNotNull(root.right.right);
		}
	}

	private static void addIfNotNull(TreeNode root) {
		// TODO Auto-generated method stub
		if (root != null) {
			ans += root.val;
		}
	}
}
