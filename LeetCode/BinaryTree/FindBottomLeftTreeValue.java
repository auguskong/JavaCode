
//Array Mapping !!! only map one element
public class Solution {
      public int findBottomLeftValue(TreeNode root) {
        return findLeftmostElement(root,1,new int[]{0,0});
    }

    private int findLeftmostElement(TreeNode root,int height,int[] result) {
        if(height>result[0]){
            result[0]=height;
            result[1]= root.val;
        }
        if(root.left!=null)findLeftmostElement(root.left,height+1,result);
        if(root.right!=null)findLeftmostElement(root.right,height+1,result);
        return result[1];
    }
}

//Right to Left Level Traversal !!! 
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) {
                queue.add(root.right);
            }
            if (root.left != null) {
                queue.add(root.left);
            }
        }
        return root.val;
    }
}