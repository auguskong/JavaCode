// 输入数组nums的取值范围是0 - n

class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i = 0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}

public int missingNumber(int[] nums) {

    int xor = 0, i = 0;
    for (i = 0; i < nums.length; i++) {
        xor = xor ^ i ^ nums[i];
    }

    return xor ^ i;
}


// Binary Search 如果本身是有序的数组可以直接使用
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;
        int mid = left + (right - left) / 2;
        while (left + 1< right) {
            mid = left + (right - left) / 2;
            // System.out.println("mid: " + mid);
            if (nums[mid] > mid) {
                // missing在左边,右边舍弃
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] != left) {
            return left;
        }
        else {
            return right;
        }
    }
}