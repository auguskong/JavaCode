
//My answer - Wrong 
class Solution {
	int min = Integer.MAX_VALUE;
	TreeNode pre = null;
	public int minDiffInBST(TreeNode root) {
		if (root == null) {
			return -1;
		}
		minDiffInBST(root.left);
		pre = root;
		if (pre != null && root.val - pre.val < min) {
			min = root.val - pre.val;
		}

		minDiffInBST(root.right);
		return min;
	}
}

class Solution {
	Integer res = Integer.MAX_VALUE, pre = null;
	public int minDiffInBST(TreeNode root) {
		if (root.left != null) minDiffInBST(root.left);
		if (pre != null) res = Math.min(res, root.val - pre);
		pre = root.val;
		if (root.right != null) minDiffInBST(root.right);
		return res;
	}
}