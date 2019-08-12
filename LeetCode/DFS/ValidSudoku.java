/*
  i |  i / 3 * 3  |  i % 3 * 3
  0        0            0
  1        0            3
  2        0            6
  3        3            0
  4        3            3
  5        3            6
  6        6            0
  7        6            3
  8        6            6
分别对应了每个小九宫格矩阵的第一个元素 再用k进行offset遍历操作
*/
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < 9; i++) {
            boolean[] rows = new boolean[9];
            boolean[] cols = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (rows[num]) {
                        return false;
                    }
                    rows[num] = true;
                }
                if (board[j][i] != '.') {
                    int num = board[j][i] - '1';
                    if (cols[num]) {
                        return false;
                    }
                    cols[num] = true;
                }
            }
            boolean[] cells = new boolean[9];
            for (int k = 0; k < 9; k++) {
                int x = k / 3 + i / 3 * 3;
                int y = k % 3 + i % 3 * 3;
                if (board[x][y] != '.') {
                    int num = board[x][y] - '1';
                    if (cells[num]) {
                        return false;
                    }
                    cells[num] = true;
                }
            }
        }
        return true;
    }
}