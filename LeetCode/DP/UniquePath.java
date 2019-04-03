/**
* Date: 06/19/18
* Type: 计数型动态规划
* Point: 初始化嵌入到整体循环之中
*
*
*/

class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                }
                else {
                    //Must have else statement
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }
}