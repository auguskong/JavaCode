class SequenceOfBST {

    public boolean isPostBST(int[] nums, int start, int end) {
        boolean isLeftBST = true;
        boolean isRightBST = true;

        if (nums == null || start > end) {
            return false;
        }

        int rootVal = nums[end];
        int index = start;
        for (; index < end; index++) {
            if (nums[index] > rootVal) {
                break;
            }
        }

        for (int j = index; j < end; j++) {
            if (nums[j] < rootVal) {
                return false;
            }
        }

        // 存在左子树
        if (index > start) {
            isLeftBST = isPostBST(nums, start, index - 1);
        }

        // 存在右子树
        if (index < end) {
            isRightBST = isPostBST(nums, index, end - 1);
        }
        return isLeftBST && isRightBST;
    }

    public static void main(String[] args) {

        int[] arrayBST = {4,3,5,8,10,9,7};
        int[] arrayNotBST = {4,9,5,8,10,3,7};

        SequenceOfBST bst = new SequenceOfBST();
        System.out.println(bst.isPostBST(arrayBST, 0, 6));
        System.out.println(bst.isPostBST(arrayNotBST, 0, 6));
    }
}

