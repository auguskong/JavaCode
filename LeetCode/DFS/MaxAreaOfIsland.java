/**
*
* Date: 06/13/18
*	
* Point: Use recursion to calculate the total area
*/

class Solution {
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int curr = 0; //store the area of the current island
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                curr = 0;
                if (grid[i][j] == 1) {
                    curr = Search(grid, i, j);
                    max = Math.max(max, curr);
                }
                
            }
        }
        return max;
    }
    
    private boolean inBound(int[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
    
    private int Search(int[][] grid, int i, int j) {
        if (!inBound(grid, i, j)) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        
        return 1 + Search(grid, i - 1, j) + Search(grid, i + 1, j) + Search(grid, i, j - 1) + Search(grid, i, j + 1);
    }
    
}