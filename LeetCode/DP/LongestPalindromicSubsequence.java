/**
* Date: 11/19/2018
* Type: DP
* Data Structure: auxilary Array
* 错点: 更新的顺序必须是从右下向左上, 从后向前依次更新。
       初始化要放在i 的for循环中,j的for循环外
* 优化: 用滚动数组进行更新: 记录当前行的相关信息 + 一个inner 长度
*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];

//         for (int i = n - 1; i >= 0; i--) {
//             dp[i][i] = 1;
//             for (int j = i + 1; j < n; j++) {
//                 // 初始化: 每个字符可以看做一个长度为1的子序列

//                 if (s.charAt(i) == s.charAt(j)) {
//                     dp[i][j] = 2 + dp[i + 1][j - 1];
//                 }
//                 else {
//                     dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
//                 }
//             }
//         }

//         return dp[0][n - 1];
        int[] f = new int[n];
        //使用滚动数组优化
        for (int i = n - 1; i >= 0; i--) {
            f[i] = 1;
            int inner = 0;
            for (int j = i + 1; j < n; j++) {
                int localMax = 0;
                if (s.charAt(i) == s.charAt(j)) {
                    localMax = 2 + inner;
                } else {
                    localMax = Math.max(f[j - 1], f[j]);
                }
                inner = f[j];
                f[j] = localMax;
            }
        }

        return f[n - 1];
    }
}