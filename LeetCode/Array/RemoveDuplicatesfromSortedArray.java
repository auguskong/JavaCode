/**
* Date: 11/13/2018
* Type: Array
* Data Structure:
* Algorithm: 同向双指针
*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            // 当前 i 所指向的位置是一个空的位置
            if (i == 0 || num > nums[i - 1])
                nums[i++] = num;
        }

        return i;·
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        nums[i++] = nums[0];
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[i++] = nums[j];
            }
        }

        return i;
    }
}