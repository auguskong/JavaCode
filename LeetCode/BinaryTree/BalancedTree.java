/*
* Date: 10/28/2018
* Type: Binary Tree
* 思路: 需要考虑遍历次数上的优化
*
*/

// 存在重复遍历的情况 对于每个节点都要判断以当前节点为root的子树是否平衡，
// 分别要求子树的深度
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (Math.abs(left - right) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.left);
        int right = getDepth(node.right);

        return Math.max(left, right) + 1;
    }
}

//遍历一次 O(n)
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}

/*Submission Result: Wrong Answer
Input:
[3,9,20,null,null,15,7]
Output:
false
Expected:
true
*/

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(getHeight(root.left) - getHeight(root.right)) < 1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
}

/*
Input:
[1,2,2,3,null,null,3,4,null,null,4]
Output:
true
Expected:
false

逻辑错误！！ 每个node节点都必须balanced
*/

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
}

/*
Accepter
*/

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
}

//JiuZhang Solution
class Solution {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    //只在子树当中进行了递归的调用，而没有在isBalanced function之中进行递归调用
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}

//My Bug Free Code
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        //对于子树isBalanced check 是递归的调用1
        if (Math.abs(left - right) > 1 || isBalanced(root.left) == false || isBalanced(root.right) == false) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //递归的调用2
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}

//之前逻辑错误的答案
//错误在于只查找了当前的root节点是否满足平衡条件而没有check 其它的剩余节点
Input: [3, 9, 20, null, null, 15, 7]
Output: false;
Expected: true;

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(getHeight(root.left) - getHeight(root.right)) < 1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
}


