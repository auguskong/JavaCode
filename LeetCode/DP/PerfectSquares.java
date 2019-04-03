/**
* Date: 11/02/2018
* Type: DP
* 数据结构: 一维数组
* 错点: 求最小值时初始化应为 最大MAX_VALUE
*
*/

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            // 初始化的j 应该是1, 也必须是1,
            // 否则会有dp[1] + 1 -> 2147483647 + 1 = -2147483648 整数溢出的问题
            int j = 1;
            //状态转移是按照平方数来转移的 i - j * j
            while (i - j * j >= 0) {
                min = Math.min(min, dp[i - j * j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}

public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for(int i = 1; i <= n; ++i) {
        int min = Integer.MAX_VALUE;
        int j = 1;
        while(i - j*j >= 0) {
            min = Math.min(min, dp[i - j*j] + 1);
            ++j;
        }
        dp[i] = min;
    }
    return dp[n];
}

class Solution {
    public int numSquares(int n) {
        int ans = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int[] dp = new int[n + 1];

        //initialization
        for (int i = 1; i <= sqrt; i++) {
            dp[i * i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                Math.min(dp[i - j * j] + 1, dp[i - 1] + 1);
            }
        }

        return dp[n];
    }
}

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            //错点：这里必须是 j = 1 而不能是j == 0 j == 0时 dp[1]直接更新为MIN_VALUE + 1
            while (i - j * j >= 0) {
                min = Math.min(min, dp[i - j * j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}