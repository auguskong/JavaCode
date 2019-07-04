/* 题目描述: 给出一棵二叉树，如果两个directly connected的节点同时被偷的话就会报警，求能够在
不触发警报的前提下偷取的最大的钱
*/

// 别人的答案: 使用递归来进行二叉树的遍历
// rob function返回的是对于当前root node来说,能够偷到的最大值 当前节点可能被偷 也可能没被偷
public int rob(TreeNode root) {
    if (root == null) return 0;

    int val = 0;

    // grandchild subtree 存在的前提是 child subtree存在
    if (root.left != null) {
        val += rob(root.left.left) + rob(root.left.right);
    }

    if (root.right != null) {
        val += rob(root.right.left) + rob(root.right.left);
    }

    return Math.max(val + root.val, rob(root.left) + rob(root.right));
}

// 优化1: 针对于overlapping of subproblem, 使用一个hashmap来记录每个节点能够偷到的最大值
class Solution {

    public int rob(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    public int robSub(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) return 0;

        if (map.containsKey(root)) {
            return map.get(root);
        }
        int val = 0;

        // grandchild subtree 存在的前提是 child subtree存在
        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);
        return val;
    }
}


// 优化2: 将rob 和 notRob 同时存到一个数组里面

public int rob(TreeNode root) {
    int[] res = robSub(root);
    return Math.max(res[0], res[1]);
}

private int[] robSub(TreeNode root) {
    if (root == null) return new int[2];

    // 数组中的第一位是不偷root节点的最大值,第二位是偷root节点的最大值
    int[] left = robSub(root.left);
    int[] right = robSub(root.right);
    int[] res = new int[2];

    // root节点不偷: 左右节点可以偷 也可以不偷， 用Math.max来取较大值
    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    // root节点偷: 左节点不偷 + 右节点不偷 + 当前节点的值
    res[1] = root.val + left[0] + right[0];

    return res;
}