package Trees;

public class PostOrderInOrder {

	private static int pre;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		pre = inorder.length - 1;
		return recur(postorder, inorder, 0, inorder.length - 1);
	}

	TreeNode recur(int[] postorder, int[] inorder, int l, int r) {
		if (l > r)
			return null;
		int val = postorder[pre--];
		int mid = l;
		for (int i = l; i <= r; i++) {
			if (inorder[i] == val) {
				mid = i;
				break;
			}
		}
		TreeNode root = new TreeNode(val);
		root.right = recur(postorder, inorder, mid + 1, r);
		root.left = recur(postorder, inorder, l, mid - 1);
		return root;
	}
}
