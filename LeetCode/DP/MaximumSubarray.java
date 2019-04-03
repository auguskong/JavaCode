/**
* 最值型DP
* Point: 状态为currMax
* Follow up: Maximum Product Subarray
* 需要用变量保存 currMax currMin两个值，因为会有负数相乘的情况
*/

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //状态为: 当前位置的最大值
        //转移方程为： Math.max(f[i - 1] + nums[i], nums[i])
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        int max = f[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
            max = Math.max(f[i], max);
        }
        return max;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int preMax = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (preMax < 0) {
                preMax = nums[i];
            } else {
                preMax = preMax + nums[i];
            }
            if (preMax > max) {
                max = preMax;
            }
        }
        return max;
    }
}


/**
* Divide and Conquer解法
*
*/
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int res = helper(nums, length);

        return res;
    }

    private int helper(int[] nums, int len) {
        //base case
        if (len == 1) {
            return nums[0];
        }
        int mid = len / 2;
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        leftSum = helper(nums, mid);
        rightSum = helper(nums, mid + 1);
        for (int i = mid + 1; i < len; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        sum = 0;
        for (int i = mid; i >= 0; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        return Math.max(leftSum + rightSum, Math.max(leftSum, rightSum));
    }

    static int maxCrossingSum(int arr[], int l,
                                int m, int h)
    {
        // Include elements on left of mid.
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--)
        {
            sum = sum + arr[i];
            if (sum > left_sum)
            left_sum = sum;
        }

        // Include elements on right of mid
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= h; i++)
        {
            sum = sum + arr[i];
            if (sum > right_sum)
            right_sum = sum;
        }

        return left_sum + right_sum;
    }


    static int maxSubArraySum(int arr[], int l,
                                      int h)
    {
    // Base Case: Only one element
    if (l == h)
        return arr[l];

    // Find middle point
    int m = (l + h) / 2;

    /* Return maximum of following three
    possible cases:
    a) Maximum subarray sum in left half
    b) Maximum subarray sum in right half
    c) Maximum subarray sum such that the
    subarray crosses the midpoint */
    return Math.max(Math.max(maxSubArraySum(arr, l, m),
                    maxSubArraySum(arr, m+1, h)),
                    maxCrossingSum(arr, l, m, h));
    }
}