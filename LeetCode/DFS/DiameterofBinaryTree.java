//maxdepth + another check  combination of procedure

class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root);
        return max;
    }
    
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int maxDepth = Math.max(left, right);
        max = Math.max(max, left + right);
        
        return maxDepth + 1;
    }
}