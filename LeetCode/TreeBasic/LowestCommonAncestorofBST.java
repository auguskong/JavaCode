Wrong Answer
Input: [2, 1, 3] 1, 3
Output: null
Expected: 2
//Wrong answer: 逻辑不完整，没有考虑到 left != null && right != null的情况
class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root.val == p.val) {
			return p;
		}
		if (root.val == q.val) {
			return q;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}

		return null;
	}
}

//Add the left != null && right != null condition check
class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root.val == p.val) {
			return p;
		}
		if (root.val == q.val) {
			return q;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		if (left != null && right != null) {
			return root;
		}
		return null;
	}
}

Wrong Answer
Input: [5, 3, 6, 2, 4, null, null, 1] 1, 4
Output: 5
Expected: 3

//Less depth do not mean the higher node is the ancestor
class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (root.val > p.val && root.val > q.val) {
			lowestCommonAncestor(root.left, p, q);
		}
		if (root.val < p.val && root.val < q.val) {
			lowestCommonAncestor(root.right, p, q);
		}
		return root;
	}
}