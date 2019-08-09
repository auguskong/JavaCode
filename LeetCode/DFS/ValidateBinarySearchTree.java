/**
* Date: 05/31/18
* Objective: Inorder Traversal + check value
* Because the Inorder Traversal is sorted element, 
	you can easily to do comparison during the traversal
*
*
*/

public boolean isValidBST(TreeNode root) {
   if (root == null) return true;
   Stack<TreeNode> stack = new Stack<>();
   TreeNode pre = null;
   while (root != null || !stack.isEmpty()) {
      while (root != null) {
         stack.push(root);
         root = root.left;
      }

      //Inorder Traversal + 
      root = stack.pop();
      if(pre != null && root.val <= pre.val) return false;
      pre = root;
      root = root.right;
   }
   return true;
 }

 //Divide & Conquer
 //Must pay attentiono to the change of level comparison

 public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, long min, long max){
        if (root == null){
            return true;
        }
        if (root.val <= min || root.val >= max){
            return false;
        }
        return helper(root.left, min, Math.min(max, root.val)) && 
                helper(root.right, Math.max(min, root.val), max);
    }
}
