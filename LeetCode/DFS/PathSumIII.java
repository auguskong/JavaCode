
//My answer: wrong output 
/*
Input:
[10,5,-3,3,2,null,11,3,-2,null,1]
8
Output:
0
Expected:
3
*/

class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        helper(root, sum);
        helper()
        return count;
    }
    
    public void helper(TreeNode root, int remain) {
        if (root == null) {
            return;
        }
        
        if (root.val == remain) {
            count += 1;
            System.out.println(count);
            return;
            
        }
        if (root.left != null) {
            helper(root.left, remain - root.val);
        }
        if (root.right != null) {
            helper(root.right, remain - root.val);
        }
    }
}

class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int pathSumFrom(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //可以有正有负，所有的路径都需要进行记录 所以要return 1 + pathSumFrom(left) + pathSumFrom(right) 而不是仅仅return 1
        return (root.val == sum ? 1 : 0) + pathSumFrom(root.left, sum - root.val) + pathSumFrom(root.right, sum - root.val);
    }
}

//03.08
Submission Result: Wrong Answer 
Input:
[10,5,-3,3,2,null,11,3,-2,null,1]
8
Output:
4
Expected:
3
/*
Wrong Answer: what happened here?
*/
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathFromSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int pathFromSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.val == sum) {
            return pathFromSum(root.left, sum) + pathFromSum(root.right, sum) + 1;
        }
        
        return pathFromSum(root.left, sum - root.val) + pathFromSum(root.right, sum - root.val);
    }
}


class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // List<List<Integer>> res = check(root, sum);
        
        return pathFromSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int pathFromSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.val == sum) {
            return pathFromSum(root.left, sum - root.val) + pathFromSum(root.right, sum - root.val) + 1;
        }
        else {
            return pathFromSum(root.left, sum - root.val) + pathFromSum(root.right, sum - root.val);
        }
        //优化的部分
        return (root.val == sum ? 1 : 0) + pathFromSum(root.left, sum - root.val) + pathFromSum(root.right, sum - root.val);
    }
    // public List<List<Integer>> check(TreeNode root, int sum) {
    //     List<List<Integer>> res = new ArrayList();
    //     if (root == null) {
    //         return res;
    //     }
    //     helper(root, sum, res, new ArrayList());
    //     return res;
    // }
    // public void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
    //     if (root == null) {
    //         return;
    //     }
    //     path.add(root.val);
    //     if (root.val == sum) {
    //         res.add(new ArrayList(path));
    //         helper(root.left, sum, res, path);
    //         helper(root.right, sum, res, path);
    //     }
    //     else {
    //         helper(root.left, sum - root.val, res, path);
    //         helper(root.right, sum - root.val, res, path);
    //     }   
    //     path.remove(path.size() - 1);
    // }
}

03.09
//compile error: 变量名写错

//Wrong answer:
Input: [10, 5, -3, 3, 2, null, 11, 3, -2, null, 1]  8
Output: 4
Expected: 3

class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return pathSum(root.left, sum) + pathSum(root.right, sum) + pathSumFrom(root, sum);
    }

    public int pathSumFrom(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.val == sum) {
            return pathSumFrom(root.left, sum) + pathSumFrom(root.right, sum) + 1;
        }
        return pathSumFrom(root.left, sum - root.val) + pathSumFrom(root.right, sum - root.val);
    }
}