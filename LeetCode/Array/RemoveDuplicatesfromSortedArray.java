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