class Solution {
    final int[] dx = new int[]{-1, 1, 0, 0};
    final int[] dy = new int[]{0, 0, 1, -1};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n]; // store the number of step
        int[][] reach = new int[m][n]; // store the number of building
        int totalBuildings = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                    queue.add(new int[]{i, j});
                    bfs(queue, grid, dp, reach, m, n);
                }
            }
        }
        // print the dp and reach array for checking
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(reach[i][j] + " ");
            }
            System.out.println("");
        }
        // step2: find the minimum distance
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reach[i][j] == totalBuildings && dp[i][j] != 0) {
                    res = Math.min(res, dp[i][j]);
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void bfs(Queue<int[]> queue,
                     int[][] grid,
                     int[][] dp,
                     int[][] reach,
                     int m,
                     int n) {


        int level = 1;
        boolean[][] visited = new boolean[m][n];
        while (!queue.isEmpty()) {
            int size = queue.size(); // 找到level为当前层的所有点
            for (int i = 0; i < size; i++) { // 遍历所有当前层节点
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                for (int k = 0; k < 4; k++) { // 四个方向bfs拓展
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n
                        || grid[nx][ny] != 0
                        || visited[nx][ny]
                        ) { // 如果超出grid的边界 或 当前节点无法到达 或 之前已经遍历过 -> 跳过
                        continue;
                    }
                    dp[nx][ny] += level;
                    reach[nx][ny]++;
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
            level++;
        }
    }
}

/**
 * Step 1: start from every point 1 (building point), doing BFS traversal to fill out (or accumulate) distance array
 * (MUST start over and doing every BFS traversal individually)
 *
 * Step 2: find minimum distance from dp array
 *
 * @param dp: store distance sum to all building for every point 0. Update values when we do BFS traversal
 * @param reach: store number of buildings that every point 0 can reach. Used for checking if current point is valid
 *             while we want to find final result
 * @param countBuilding: count total number of point 1
 * */
final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
public int shortestDistance(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[][] dp = new int[n][m];
    int[][] reach = new int[n][m];
    int countBuilding = 0;
    Queue<int[]> queue = new LinkedList<>();

    // step 1
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 1) {
                queue.offer(new int[]{i, j});
                bfs(queue, grid, dp, reach, n, m);
                countBuilding++;
            }
        }
    }

    // step 2
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            // WARNING: DO NOT FORGET to check whether current point is 0 and whether current point can reach all buildings
            if (grid[i][j] == 0 && reach[i][j] == countBuilding) {
                result = Math.min(result, dp[i][j]);
            }
        }
    }
    return result == Integer.MAX_VALUE ? -1 : result;
}

public void bfs(Queue<int[]> queue, int[][] grid, int[][] dp, int[][] reach, int n, int m) {
    int level = 1;
    // DO NOT USE hashset, since hashset cannot determine whether it contains an array (coordinate)
    boolean[][] visited = new boolean[n][m];
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int[] curPoint = queue.poll();
            int x = curPoint[0];
            int y = curPoint[1];
            for (int j = 0; j < 4; j++) {
                int dx = x + dir[j][0];
                int dy = y + dir[j][1];
                if (dx < 0 || dx > n - 1 || dy < 0 || dy > m - 1 || grid[dx][dy] != 0 || visited[dx][dy]) {
                    continue;
                }
                queue.offer(new int[]{dx, dy});
                visited[dx][dy] = true;
                dp[dx][dy] += level;
                reach[dx][dy]++;
            }
        }
        level++;
    }
}