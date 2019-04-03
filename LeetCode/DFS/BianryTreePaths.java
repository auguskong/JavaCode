/**
* Date: 11/02/2018
* Type: DFS
* 数据结构: 无
*/

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        String curr = "";
        helper(root, res, curr);
        return res;
    }

    private void helper(TreeNode root, List<String> res, String curr) {
        /* 递归的出口:
           1.头结点: 该题比较特殊的一个情况，因为第一个头结点不需要添加`->`符号，需要单独处理
           2.叶节点:
           3.空节点: 空节点必须在前，因为可能会在没有遇到叶节点之前（较高层）就遇到了空节点，
                    对于空节点root.left, root.right 会出现Null Pointer异常
           递归的调用: 针对中间节点，二叉树直接分两段 root.left 以及 root.right
        */
        if (root == null) {
            return;
        }

        if (curr.equals("")) {
            curr = curr + root.val;
        }
        else {
             curr = curr + "->" + root.val;
        }
        //注意这里必须是叶节点终止！！
        if (root.left == null && root.right == null) {
                res.add(curr);
        }
        helper(root.left, res, curr);
        helper(root.right, res, curr);
    }
}