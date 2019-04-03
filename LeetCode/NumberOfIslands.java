/*
* Date: 10/24/2018
* Type: LinkedList
* 数据结构: Queue, Adjancency List
* 算法: DFS 搜索
*/

class NumberOfIslands {

    public static void main(String[] args) {
        char[][] test = {{'1', '0', '1', '1', '0', '1', '1', '1'}};
        System.out.println(numIslands(test));
    }
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        System.out.println("rows" + rows);
        System.out.println("cols" + cols);
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    System.out.println("Inside for loop" + "row: " + i + "col: " + j);
                    Search(grid, i, j, dx, dy);
                    printIsland(grid);
                    count++;
                }
            }
        }

        return count;
    }

    private static void Search(char[][] grid, int row, int col, int[] dx, int[] dy) {
        System.out.println("Inside search");
        // 错点：没有写grid[0] 当中的[0]一直返回的都是row 而不是 col
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }

        grid[row][col] = '0';
        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == '1') {
                Search(grid, nx, ny, dx, dy);
            }
        }

    }

    private static void printIsland(char[][] grid) {
        System.out.println("Inside printIsland");

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
}