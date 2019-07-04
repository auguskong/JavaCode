import java.util.*;
import java.io.*;

class Solution {
	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null) {
			return null;
		}
		if (root.val > R) {
			return trimBST(root.left, L, R);
		}
		if (root.val < L) {
			return trimBST(root.right, L, R);
		}
		//隐含条件: root.val > L && root.val < R
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);

		return root;
	}

	//
	public static void main(String[] args) {
		Solution res = new Solution();
		...
	}
}