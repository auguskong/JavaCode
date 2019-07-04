class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        if (root == null) {
            return res;
        }

        if (res.size() == 0) {
            res.add("" + root.val);
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);

        for (String path : leftPaths) {
            res.add(root.val + "->" + path);
        }
        for (String path : rightPaths) {
            res.add(root.val + "->" + path);
        }
        return res;
    }
}

//03.09
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        if (root == null) {
            return res;
        }
        List<String> leftPath = binaryTreePaths(root.left);
        List<String> rightPath = binaryTreePaths(root.right);
        for (String path : leftPath) {
            path.add(root.val + "->" + path); //WRONG: res.add();
        }
        for (String path : rightPath) {
            path.add(root.val + "->" + path);
        }
        if (res.size() == 0) {
            res.add("" + root.val);
        }
    }
}

//AC solution
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        if (root == null) {
            return res;
        }
        List<String> leftPath = binaryTreePaths(root.left);
        List<String> rightPath = binaryTreePaths(root.right);
        System.out.println(root.val);
        for (String path : leftPath) {
            res.add(root.val + "->" + path);
        }
        for (String path : rightPath) {
            res.add(root.val + "->" + path);
        }
        if (res.size() == 0) {
            res.add("" + root.val);
        }
        System.out.println(leftPath);
        System.out.println(res);
        return res;
    }
}

//03.14
Runtime Error

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList();
        if (root == null) {
            return res;
        }
        res = helper(res, new ArrayList<String>(), root);
        return res;
    }

    public List<String> helper(List<String> res, List<String> path, TreeNode root) {
        if (root == null) {
            return path;
        }

        List<String> leftPaths = helper(res, path, root.left);
        List<String> rightPaths = helper(res, path, root.right);

        for (String curr : leftPaths) {
            res.add(root.val + "->" + curr);
        }
        for (String curr : rightPaths) {
            res.add(root.val + "->" + curr);
        }
        if (path.size() == 0) {
            path.add("" + root.val);
        }
        return res;
    }

}