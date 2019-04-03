class Solution {
    public int pathSum(TreeNode root, int sum) {
        //base case
        if (root == null) {
            return 0;
        }

        return containPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int containPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        res += containPath(root.left, sum - root.val);
        res += containPath(root.right, sum - root.val);
        return res;
    }
}