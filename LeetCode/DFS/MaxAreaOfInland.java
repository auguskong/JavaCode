/**
*
*
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 ) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = findArea(grid, i, j, rows, cols, 1);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }


    private int findArea(int[][] grid, int i, int j, int rows, int cols, int area) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != 1) {
            return 0;
        }
        area++;
        //StackOverflow Error 为什么呢？ 没有把已经遍历过的小岛淹掉，会出现持续的遍历，爆栈
        findArea(grid, i + 1, j, rows, cols, area);
        findArea(grid, i - 1, j, rows, cols, area);
        findArea(grid, i, j + 1, rows, cols, area);
        findArea(grid, i, j - 1, rows, cols, area);

        return area; //第二个问题: 返回值不对，感觉是引用传递的问题
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 ) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = findArea(grid, i, j, rows, cols);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }


    private int findArea(int[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 0;
        return findArea(grid, i + 1, j, rows, cols)+
        findArea(grid, i - 1, j, rows, cols)+
        findArea(grid, i, j + 1, rows, cols)+
        findArea(grid, i, j - 1, rows, cols) + 1;

    }
}