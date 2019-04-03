/**
*
*
*
*Sample input:
[[1,1,0],
 [1,1,0],
 [0,0,1]]
*Sample output: 2

*Sample input:
[[1,1,0],
 [1,1,1],
 [0,1,1]]
*Sample output: 1
* 1代表直接的朋友关系
*/

public class Solution {
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}

// 优化: 不使用visited数组进行记录
public class Solution {
    public void dfs(int[][] M, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1) {
                M[i][j] = M[j][i] = 0;
                dfs(M, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1) {
                dfs(M, i);
                count++;
            }
        }
        return count;
    }
}