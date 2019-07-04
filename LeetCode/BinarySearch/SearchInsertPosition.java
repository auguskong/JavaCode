/*
题目描述: 给出一个target和一个 nums数组, 如果在nums数组中能够找到target 那么就直接返回target
的index, 否则返回target应该插入的位置的index
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (target <= nums[left]) {
            return left;
        }
        if (target > nums[right]) {
            return right + 1;
        }
        return right;
    }
}


public int searchInsert(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    if (nums.length == 0) {
        return 0;
    }
    while (start < end) {
        // 使用start < end作为while中的判断语句的话 最后会在start == end 时中止循环
        int mid = (start + end) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            end = mid;
        } else {
            start = mid + 1;
        }
    }
    //目标值在不在当前停的位置的前边还是后边
    if(target > nums[start]){
        return start + 1;
    }
    //如果小于的话，就返回当前位置，跑步超过第二名还是第二名，所以不用减 1。
    else{
        return start;
    }
}