
//全局递归迭代调用
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null) {
            //case1: it is a leaf node
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
            //case2: it it not a leaf node
            else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        sum += sumOfLeftLeaves(root.right);
        
        return sum;
    }
}

//分层递归迭代调用
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}