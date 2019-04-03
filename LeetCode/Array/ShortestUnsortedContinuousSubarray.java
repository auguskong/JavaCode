/**
* Date: 11/19/2018
* Type: Two Pointers
* Data Structure: auxilary Hash Array
* 思路: 最短的未排序数组就是第一个值和sorted Array不一致的位置, 使用一个排好序的数组
*
*/

class Solution {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int[] aux = Arrays.copyOf(nums, n);

        int left = 0;
        int right = n - 1;
        while (left < n && nums[left] == aux[left]) {
            left++;
        }
        // 小优化: right > left 直接减少了对交叉的情况的判断
        while (right > left && nums[right] == aux[right]) {
            right--;
        }

        // 算长度要记得将index的差值 + 1
        return right - left + 1;
    }

    // O(n)的解法, 很tricky 还没看明白
    public int findUnsortedSubarray(int[] nums) {

        int i = 0, j = -1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int n = nums.length;
        //
        for (int l = 0, r = nums.length - 1; r >= 0; l++, r--) {
            max = Math.max(max, nums[l]);
            if (nums[l] != max) j = l;

            min = Math.min(min, nums[r]);
            if (nums[r] != min) i = r;
            // System.out.println("loop number: " + l + " ");
            // System.out.println("end: " + j + " start: " + i + " max: " + max + " min: " + min + " l: " + l + " r: " + r);

        }

        return (j - i + 1);
    }
}