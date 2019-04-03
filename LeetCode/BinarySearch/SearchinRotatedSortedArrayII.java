/**
* Date: 10/31/2018
* Type: Bianry Search
* 数据结构:
* Follow up点: 出现重复值
* A:    if (nums[mid] > nums[left]) {保留I中代码}
        else if (nums[mid] < nums[left]) {保留I中代码}
        else {start++} //早晚会有不相等的那一天
* 思路: 重复值会有什么影响？？会出现二分判断舍弃哪个区间失效的问题
* 错点: 陷入了 nums[left] 和 nums[right]的比较之中，这两者之间的比较是没有意义的, Binary
*      Search的关键思想在于判断target落在哪个区间内，舍弃肯定不存在的区间，来逐步缩小查找的范围
* Review: 11.18 必须要考虑等于的情况 例如nums[left] <= target && target <= nums[mid]
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
            // nums[mi] > nums[left] 表示mid在左半边
            if (nums[mid] > nums[left]) {
                // 判断target已经位于了左半边的范围内，可以完全将右半段舍弃 -> right = mid
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } // 判断target肯定不在左半边范围，直接将左半段舍弃
                else {
                    left = mid;
                }
            } // 同理考虑mid在右半边的情况
            else if (nums[mid] < nums[left]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                }
                else {
                     right = mid;
                }
            } else {
                left++;
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