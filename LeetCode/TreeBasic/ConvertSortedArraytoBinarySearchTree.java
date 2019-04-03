class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = buildTree(nums, 0, nums.length - 1);
        return root;
    }
    
    public TreeNode buildTree(int[] nums, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildTree(nums, 0, mid - 1);
            root.right = buildTree(nums, mid + 1, end);
        }
        
        return root;
    }
}

//Binary Search + Construct Tree Node
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = buildTree(nums, 0, nums.length - 1);
        return root;
    }
    
    public TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, 0, mid - 1);
        root.right = buildTree(nums, mid + 1, end);
        
        return root;
    }
}