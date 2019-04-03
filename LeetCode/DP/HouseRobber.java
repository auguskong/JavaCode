/**
* Date: 10/31/2018
* Type: DP
* 数据结构:
* 思路: 最大值只可能来自于 抢了当前的就不能抢下一个
*/

/*
* 错点:
* 1. DP信息记录不完整，只使用一个数组不足以记录抢和被抢的信息
* dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]); 这个转移方程只是紧邻的元素之间的
* 关系，有可能存在要隔多个再抢的情况比如[2, 1, 1, 2]
* 2. Corner Case 没有考虑完整 长度为0, 1, 2都要考虑
* 3. 没有初始化数组 rob[0] = nums[0]
* 4. 起点是从 只考虑的是上一个房子的关系:

*优化: 用两个变量来代替DP数组
*/
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] nRob = new int[n];
        int[] rob = new int[n];
        rob[0] = nums[0]; //这一步必须要有！
        for (int i = 1; i < n; i++) {
            nRob[i] = Math.max(rob[i - 1], nRob[i - 1]);
            rob[i] = nRob[i - 1] + nums[i];
        }

        return Math.max(rob[n - 1], nRob[n - 1]);
    }
}

class Solution {
    public int rob(int[] nums) {
        int rob = 0;
        int notRob = 0;
        for (int num : nums) {
            int pre = Math.max(notRob, rob);
            rob = notRob + num;
            notRob = pre;
        }

        return Math.max(rob, notRob);
    }
}