/**
* Date: 11/13/2018
* Type: Array
* Data Structure:
* Algorithm: 同向双指针
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        /*
        int i = -1;

        while (true) {
            while (nums[++i] != 0) {
                if (i == n - 1) break;
            }
            int j = i;
            // 当只有一个元素的时候会存在数组越界的问题
            //[0], i = 0, j = i = 0, ++j = 1 越界, 错点: 同向双指针要同时移动
            while (j < n && nums[++j] == 0) {
                if (j == n - 1) break;
            }
            swap(nums, i, j);

            if (j == n - 1) break;
        }
        */
        int left = 0, int right = 0;
        while (right < n) {
            // right指向第一个非零的数字，而left指向第一个为零的数字, 转换之后直接继续遍历, 知道
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] A, int i, int j) {
        int swap = A[i];
        int A[i] = A[j];
        A[j] = swap;
    }
}