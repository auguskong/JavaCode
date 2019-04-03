/**
*
* Date: 06/13/18
*
*/

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    Search(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private boolean inBound(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    private void Search(char[][] grid, int i, int j) {
        if (!inBound(grid, i, j)) {
            return;
        }

        if (grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        Search(grid, i + 1, j);
        Search(grid, i - 1, j);
        Search(grid, i, j + 1);
        Search(grid, i, j - 1);
    }
}

/**
* Date: 11/15/2018
* Type: DFS
*/

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    Search(grid, i, j, rows, cols);
                }
            }
        }
        return islands;
    }

    private void Search(char[][] grid, int row, int col, int rows, int cols) {
        // if里面必须要先判断数组是否越界 再判断grid[row][col] 是否为'1'!! 否则会有报错
        if (row >= rows || row < 0 || col >= cols || col < 0 || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '0';
        Search(grid, row + 1, col, rows, cols);
        Search(grid, row - 1, col, rows, cols);
        Search(grid, row, col - 1, rows, cols);
        Search(grid, row, col + 1, rows, cols);
    }
}