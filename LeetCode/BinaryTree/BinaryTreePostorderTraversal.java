/**
* Date: 05/30/18
* Objective: two pointers + stack data structure
*
*
*/

class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return null;
		}
		TreeNode curr = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			curr = stack.peek();
			if (root.left != null && curr != root.left && curr != root.right) {
				stack.push(root.left);
			}
			else if (root.right != null && curr != right) {
				stack.push(root.right);
			}
			else {
				root = curr;  //Why root = curr not curr = root??
				res.add(stack.pop().val);
			}
		}

		return res;
	}
}