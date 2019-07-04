
//Run time error: 
class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}

		Stack<TreeNode> stack = new Stack();
		stack.push(root);

		while (!stack.isEmpty() || root != null) {
			root = stack.pop();
			if (root.left != null) {
				stack.push(root.left);
			}
			else {
				stack.push(root.right);
				res.add(root.val);
			}
		}

		return res;
	}
}


//Time Limit Error
// End node is null node
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                res.add(root.val);
                if (root.right != null) {
                    root = root.right;
                }
            }
        }
        
        return res;
    }
}