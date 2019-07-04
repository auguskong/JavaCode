// 单点source的BFS 不需要遍历整个二维数组

// 我的答案:
class Solution {
    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return new int[][]{};
        }

        // 这个check条件很关键 - 对于特殊情况下
        if (image[sr][sc] == newColor) return image;
        Queue<int[]> queue = new LinkedList<>();

        int oldColor = image[sr][sc];
        int rows = image.length;
        int cols = image[0].length;
        boolean[][] visited = new boolean[rows][cols];
        queue.add(new int[] {sr, sc});
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            int x = loc[0];
            int y = loc[1];
            image[x][y] = newColor;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 &&
                    nx < rows &&
                    ny >= 0 &&
                    ny < cols &&
                    image[nx][ny] == oldColor) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return image;
    }
}

// 另一种解法 DFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, color, newColor);
        fill(image, sr - 1, sc, color, newColor);
        fill(image, sr, sc + 1, color, newColor);
        fill(image, sr, sc - 1, color, newColor);
    }
}