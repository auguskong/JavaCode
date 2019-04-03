//Combination of Diameter of a tree + another equality check 
//Final solution
class Solution {
    int max = 0; // store the length of current longest path
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //max = 0;
        helper(root, root.val);
        return max;
    }
    
    public int helper(TreeNode node, int val) {
        //base case: node == null go to the end
        if (node == null) {
            return 0;
        }
        int left = helper(node.left, node.val);
        int right = helper(node.right, node.val);
        max = Math.max(left + right, max); //？？？？
        if (node.val == val) {
            return Math.max(left, right) + 1; 
        }
        return 0;
    }   
}
//Code for Diameter of Binary Tree Question
class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root);
        return max;
    }
    
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int maxDepth = Math.max(left, right);
        max = Math.max(max, left + right);
        
        return maxDepth + 1;
    }
}

/*
Input:
[1,4,5,4,4,5]
Output:
0
Expected:
2
*/
class Solution {
    int max = 0; // store the length of current longest path
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, root.val);
        return max;
    }
    
    public int helper(TreeNode node, int val) {
        //base case: node == null go to the end
        if (node == null) {
            return 0;
        }
        int left = helper(node.left, node.val);
        int right = helper(node.right, node.val);
        if (node.val == val) {
            max = Math.max(left + right, max); //？？？？
            return Math.max(left, right) + 1;
        }
        else {
            return 0;
        }
    }   
}

class Solution {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, root.val);
        return max;
        
    }
    
    public int helper(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        //pass the value
        if (root.val == val) {
            int left = helper(root.left, val);
            int right = helper(root.right, val);
            max = Math.max(left + right, max);
        }
        //start from the current
        if (root.left != null) {
            return helper(root.left, root.val);
        }
        if (root.right != null) {
            return helper(root.right, root.val);
        }
        return  //@@stuck here@@
    }
}


class Solution {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        max = helper(root, root.val); 
        //出错的地方， 不能调用 max = helper(root, root.val) -> 限定了起点只可能是root
        return max;
    }
    
    public int helper(TreeNode root, int val) {
        //base case: get the null node
        if (root == null) {
            return 0;
        } 
        
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        max = Math.max(left + right, max);
        if (root.val == val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}

Submission Result: Wrong Answer 
Input:
[1,4,5,4,4,5]
Output:
0
Expected:
2
/*
What happened here? why must update max out of the for loop
*/
class Solution {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, root.val);
        return max;
    }
    
    public int helper(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        
        if (root.val == val) {
            max = Math.max(left + right, max);
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}