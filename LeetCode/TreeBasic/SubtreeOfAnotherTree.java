//Wrong answer: [1, 1] [1] E: true O: false 最后的true的判断条件有问题

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s== null || t == null) {
            return false;
        }
        
        if (s.val == t.val) {
            return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
        }
        else if (s.val != t.val) {
            if (s.left != null) {
               return isSubtree(s.left, t);
            }
            if (s.right != null) {
               return isSubtree(s.right, t); 
            }
        }
        
        return false;
    }
}

Wrong Answer:
Input:
[3,4,5,1,2,null,null,0]
[4,1,2]
Output:
true
Expected:
false


class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return true;
        }
        if (s.val == t.val) {
            return isSame(s.left, t.left) && isSame(s.right, t.right);
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
}


class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if(isSame(s, t)) {
            return true;
        }
        if (isSubtree(s.left, t) || isSubtree(s.right, t)) {
            return true;
        }
        return false;
    }
    
    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
}



class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null) return t==null;
        return isSame(s,t)||isSubtree(s.left,t)||isSubtree(s.right,t);
    }
    
    public boolean isSame(TreeNode s, TreeNode t){
        if(s==null&&t==null) return true;
        else if(s==null||t==null) return false;
        
        if(s.val!=t.val) return false;
        return isSame(s.left,t.left)&&isSame(s.right,t.right);
    }
}

//Runtime Error: 
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s != null && t == null) {
            return true;
        }
        if (s == null && t == null) {
            return true;
        }
        if (s.val != t.val) {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        if (s.val == t.val) {
            return isSame(s, t);
        }
        //not find
        return false;
    }
    
    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == t;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}


Submission Result: Wrong Answer 
Input:
[1,1]
[1]
Output:
false
Expected:
true

//wrong answer: 提前进行了终止，错过了可能的正确答案 去掉if(s.val == t.val)
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        //because s's subTree must be exactly same with the t
        if (s.val == t.val) {
            return isSame(s, t);
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);   
    }
    
    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
}

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        //because s's subTree must be exactly same with the t
        if (isSame(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);   
    }
    
    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
}
