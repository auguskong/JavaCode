class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return null;
        }
        TreeNode root = buildTree(t1, t2);
        root.right = buildTree(t1.right, t2.right);
        root.left = buildTree(t1.left, t2.left);
        return root;
    }
    
    public TreeNode buildTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        }
        else if (t1 == null) {
            return t2;
        }
        else if (t2 == null) {
            return t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        System.out.println(root.val);
        return root;
    }
}