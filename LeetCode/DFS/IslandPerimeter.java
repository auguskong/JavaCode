/**
* Date: 06/13/18
* 我的思路: 5个 if 条件判断 -> 1个neighbor -> 3, 2个 -> 2, 3个 -> 1, 4个 -> 0 
* Point: 跳转思路，统计总量而不是单独, island * 4 - overall * 2;
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0;
        int overlaps = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    if (i + 1 < rows && grid[i + 1][j] == 1) {
                        overlaps++;
                    }
                    if (j + 1 < cols && grid[i][j + 1] == 1) {
                        overlaps++;
                    }
                }
            }
        }
        
        return islands * 4 - overlaps * 2;
    }
}