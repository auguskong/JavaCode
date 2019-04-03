/**
* Date: 10/25/2018
* Type: Tree Level Order Traversal
* Point:
*
*/

/*
* Recursion Solution:
* 递归的出口: root == null OR
            root.left == null && root.right == null OR
            root.left == null OR
            root.right == null OR
            root.left != null && root.right != null
* 递归的调用：1 + minDepth(root.right) OR
            1 + minDepth(root.left)
* 递归的拆解：左子树 + 右子树
*/
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        else if (root.left == null) return 1 + minDepth(root.right);
        else if (root.right == null) return 1 + minDepth(root.left);
        else return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}

/*
* Iterative Solution:
* 数据结构: Queue level order traversal, 从上向下逐层遍历，遇到了第一个叶节点时直接返回
* 当前的层数就是全树最小层
*
*/
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }

        return -1;
    }
}