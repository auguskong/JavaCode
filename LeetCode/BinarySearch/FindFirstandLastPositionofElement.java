/**
* Date: 10/31/2018
* Type: Bianry Search
* 数据结构:
* 思路: 先找start position 再找end position
*/

/*
* 错点:
* 1. 数组初始化语法错误 return {-1, -1}/return new int[] -> return new int[]{-1, -1}
* 2. 重复定义变量 line24: int start  line54: int start
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int n = nums.length;
        if (target > nums[n - 1] || target < nums[0]) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        int start = 0;
        int end = n - 1;
        //find the start position
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            //优化: 这两个if 和 else判断可以进行合并
            // if (nums[mid] == target) {
            //     end = mid;
            // } else if (nums[mid] < target) {
            //     start = mid;
            // } else {
            //     end = mid;
            // }
            //优化后的版本:
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] == target) {
            res[0] = start;
        } else if (nums[end] == target) {
            res[0] = end;
        } else {
            return new int[]{-1, -1};
        }

        // int res[0] = (nums[start] == target) ?
        //              start : (nums[end] == target ? end : -1);

        //find the end position
        start = res[0];
        end = n - 1;
         while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            res[1] = end;
        } else if (nums[start] == target) {
            res[1] = start;
        } else {
            return new int[]{-1, -1};
        }
        return res;
    }
}