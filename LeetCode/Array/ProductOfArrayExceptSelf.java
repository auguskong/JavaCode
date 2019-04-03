/**
* 10/27/2018
* Type: Array
* 数据结构: 无
* 考点: Corner Case的处理能力， 要考虑到没有零，一个零和多个零的情况
*/


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int productSum = 1;
        int countZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                productSum *= nums[i];
            }
            else {
                countZero++;
            }
        }

        if (countZero > 1) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (countZero > 0) {
                if (nums[i] == 0) {
                    res[i] = productSum;
                }
                else {
                    res[i] = 0;
                }
            }
            else {
                res[i] = productSum / nums[i];
            }
        }
        return res;
    }
}