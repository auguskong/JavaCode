/**
* Date: 11/13/2018
* Type: Array
* Data Structure:
* Algorithm: 同向双指针
*/

// 正确的写法
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
        int left = 0;
        int right = 0;
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
        A[i] = A[j];
        A[j] = swap;
    }
}

// 另一种解法: 使用for loop 来限定local variable的范围
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int left = 0, right = 0; right < nums.length;right++) {
            System.out.println("right: " + right);
            System.out.println("left: " + left);
            // 当right第一次跑到left的前面的时候,left一定是指向0的
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
        }
        return;
    }

    private void swap(int[] A, int i, int j) {
        int swap = A[i];
        A[i] = A[j];
        A[j] = swap;
    }
}

// 错误的写法:
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        int right = 0;
        int size = nums.length;
        // 这样的写法有个问题是 right可能跑到left前面 这样就会将0向前置换
        while (right < size - 1 && nums[right] == 0) {
            right++;
            while (left < size - 1 && nums[left] != 0) {
                left++;
            }
            swap(left, right, nums);
        }
        return;
    }

    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

/* test case
必须要宝恒right元素在left元素的右边

已经满足要求: [1,0]
首个元素为零: [0, 1]
中间元素为零: [1,0,1]
*/