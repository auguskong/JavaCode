
Submission Result: Wrong Answer 
Input:
[5,4,8,11,null,13,4,7,2,null,null,5,1]
22
Output:
[[5,4,11,7,2],[5,4,11,7,2,8,13,4,5]]
Expected:
[[5,4,11,2],[5,8,4,5]]
/*
WRONG: Forget the reduction statement
*/

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }
        helper(root, sum, res, new ArrayList());
        return res;
    }
    
    public void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.val == sum) {
            res.add(new ArrayList(path));
        }
        helper(root.left, sum - root.val, res, path);
        helper(root.right, sum - root.val, res, path);
    }
}

Submission Result: Wrong Answer 
Input:
[1,2]
1
Output:
[[1]]
Expected:
[]

/*
the end point should be a leaf node 
*/
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }
        helper(root, sum, res, new ArrayList());
        return res;
    }
    
    public void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.val == sum) {
            res.add(new ArrayList(path));
        }
        helper(root.left, sum - root.val, res, path);
        helper(root.right, sum - root.val, res, path);
        path.remove(path.size() - 1);
    }
}


class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }
        helper(root, sum, res, new ArrayList());
        return res;
    }
    
    public void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            res.add(new ArrayList(path));
        }
        helper(root.left, sum - root.val, res, path);
        helper(root.right, sum - root.val, res, path);
        path.remove(path.size() - 1);
    }
}


//AC 代码
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }
        helper(root, sum, res, new ArrayList());
        return res;
    }
    
    public void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            res.add(new ArrayList(path));
        }
        helper(root.left, sum - root.val, res, path);
        helper(root.right, sum - root.val, res, path);
        path.remove(path.size() - 1);
    }
}