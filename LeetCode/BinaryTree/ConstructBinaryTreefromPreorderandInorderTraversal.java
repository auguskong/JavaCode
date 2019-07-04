/**
* Date: 11/21/2018
* Data Structure:
* Algorithm: for 循环
* 错点: 数组index索引下标处理要细致 index - instart确定左子树元素个数 inEnd - index确定右子树元素个数
* Related Question: Construct Binary Tree from Inorder and Postorder Traversal
*/

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        // inIndex - inStart 表示的是左子树的长度, 有了左子树的长度之后, index之间的差值表示的是长度, 是元素个数 - 1
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1 + , inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}


// 通过inorder 和 postorder 来遍历
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        int n = inorder.length;
        TreeNode root = helper(inorder, postorder, 0, n - 1, n - 1);

        return root;
    }

    // inStart和inEnd必须要有 根节点index索引一定要有 postOrder中是最后一个元素 postEnd, preOrder中是第一个元素 preStart
    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd) {
        /* 递归的终止条件一定要有:
            postEnd是不断前移的,左边界是0
            inStart是不断后移的, 右边界为inEnd
        */
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int val = root.val;
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        // 改为判断
        root.left = helper(inorder, postorder, inStart, index -1, postEnd - 1 - (inEnd - index));
        root.right = helper(inorder, postorder, index + 1, inEnd, postEnd - 1);

        return root;
    }
}

