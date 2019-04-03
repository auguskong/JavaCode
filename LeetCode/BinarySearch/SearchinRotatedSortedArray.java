/**
* Date: 10/31/2018
* Type: Bianry Search
* 数据结构:
* 思路:
* 错点: 陷入了 nums[left] 和 nums[right]的比较之中，这两者之间的比较是没有意义的, Binary
*      Search的关键思想在于判断target落在哪个区间内，舍弃肯定不存在的区间，来逐步缩小查找的范围
*/

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // nums[mid] > nums[left] 表示mid和left在同侧，存在mid和left之间的单调性
            if (nums[mid] > nums[left]) {
                // 判断target已经位于左半边的范围内，可以完全将右半段舍弃 -> right = mid
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } // 判断target肯定不在左半边范围，直接将左半段舍弃
                else {
                    left = mid;
                }
            } // 同理考虑mid和left在不同侧, 不同侧中只能判断的是mid和right之间的单调性
            else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                }
                else {
                     right = mid;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }

        return -1;
    }
}