
//03.09 First Submission


class Solution {
    public int sumNumbers(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        
        helper(root, new ArrayList(), res);
        int sum = 0;
        for (int i = 0; i < res.size(); i++) {
            sum += res.get(i);
        }
        return sum;
    }
    
    public void helper(TreeNode root, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList(path));
        }
        helper(root.left, path, res);
        helper(root.right, path, res);
    }
}

class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode n, int s) {
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s * 10 + n.val;
        return sum(n.left, s * 10 + n.val) + sum(n.right, s * 10 + n.val);
    }
}