public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                count++;
                // 错点: 这个位置必须要进行 指针的移动操作
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                // 去重是和已经处理过的数据进行比较 而不是而还没有处理过的
                // 所以left 和左边left - 1, right 和 right + 1 比较
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }

        return count;
    }
}