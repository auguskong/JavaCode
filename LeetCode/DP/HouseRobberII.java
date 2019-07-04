/* 题目描述: 一排首尾相连的房子,可以看做一个环, 在不连续偷两个相邻的房子的前提下 能够偷到的最大
值是多少?
*/

// 别人的答案: 分类讨论 将一个环拆解为两个直线,断点可以任选 1-2-3-1 变为 1-2 和 2-3 因为
// 如果偷了1 一定不能偷 3 所以只剩下 1-2
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 两种情况
        // 第一个房子不偷 (1, nums.length - 1) 和第一个房子偷(0, nums.length - 2)
        return Math.max(robHelper(nums, 1, nums.length - 1),
                        robHelper(nums, 0, nums.length - 2));
    }

    public int robHelper(int[] nums, int lo, int hi) {
        int rob = 0;
        int notRob = 0;
        for (int i = lo; i <= hi; i++) {
            int pre = Math.max(notRob, rob);
            rob = notRob + nums[i];
            notRob = pre;
        }

        return Math.max(rob, notRob);
    }
}