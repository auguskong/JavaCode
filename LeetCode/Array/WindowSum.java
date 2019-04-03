/**
* Date: 11/13/2018
* Type: Array
* Data Structure:
* Algorithm: 同向双指针
*/

public class Solution {
    /**
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int left = 0;
        int right = k - 1;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        // while (right + 1 < n) {
        //     res[left] = sum;
        //     right++;
        //     sum += (nums[right] - nums[left]);
        //     left++;
        // }
        // res[left] = sum;

        //优化: 每一次都固定向前走一步, 可以直接用for loop
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] - nums[i - 1] + nums[i + k - 1];
        }
        return res;
    }
}