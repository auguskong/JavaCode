public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root == null) return list;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while(!stack.empty()){
        root = stack.pop();
        list.add(0, root.val); // 直接将root节点加入到链表的头上位置
        if(root.left != null) stack.push(root.left);
        if(root.right != null) stack.push(root.right);
    }
    return list;
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();

        TreeNode higher = null;
        TreeNode curr = root;
        stack.push(curr);
        while(!stack.empty()){
            higher = stack.peek();
            if (higher.left != null && curr != higher.left && curr != higher.right) {
                stack.push(higher.left);
            }
            else if (higher.right != null && curr != higher.right) {
                stack.push(higher.right);
            } else {
                higher = stack.pop();
                res.add(higher.val);
                curr = higher;
            }
        }
        return res;
    }
}