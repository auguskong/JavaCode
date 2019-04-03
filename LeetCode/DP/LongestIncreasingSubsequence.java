/**
*
*
*
*
*/

public class LongestIncreasingSubsequence {
    public int calculate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int max = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }

    /*如果想要找到整个subsequence, 可以通过dp数组逆向查找, 查找的原则是
    dp[i] = dp[index] - 1 && nums[i] < nums[index]
    */

    public int[] generateLIS(int[] nums, int[] dp) {

        int n = nums.length;
        int len = 0; // used to locate the element in subsequence array
        int index = 0; // used to locate the element in nums array and dp array
        for (int i = 0; i < n; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        int[] subsequence = new int[len];

        dp[--len] = nums[index];
        // len对应的
        for (int i = index; i >= 0; i--) {
            if (dp[i] = dp[index] - 1 && nums[i] < nums[index]) {
                subsequence[--len] = nums[i];
                index = i;
            }
        }

        return subsequence;
    }
    public int calculateBinary(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int max = 0;
        int[] dp = new int[n];
        int size = 0;
        for (Integer num : nums) {
            int start = 0;
            int end = size;
            while (start != end) {
                int mid = start + (end - start) / 2;
                if (dp[mid] < num) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            dp[start] = num;
            if (size == start) {
                size++;
            }
        }

        return size;
    }
}

