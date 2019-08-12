class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int k = j / 3 + (i / 3) * 3;
                    rows[i][num] = cols[j][num] = blocks[k][num] = true;
                }
            }
        }

        dfs(board, rows, cols, blocks, 0);
    }

    private boolean dfs(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] blocks, int index) {
        if (index == 81) {
            return true;
        }
        int row = index / 9;
        int col = index % 9;
        int block = col / 3 + (row / 3) * 3;
        // 如果当前位置不为空，则直接跳到下一个位置
        if (board[row][col] != '.') {
            return dfs(board, rows, cols, blocks, index + 1);
        }
        for (char chr = '1'; chr <= '9'; chr++) {
            int num = chr - '1';
            // 先要保证要填的数字 在当前位置的同一行 同一列 同一个九宫格中不存在
            if (!rows[row][num] && !cols[col][num] && !blocks[block][num]) {
                board[row][col] = chr;
                rows[row][num] = cols[col][num] = blocks[block][num] = true;
                if (dfs(board, rows, cols, blocks, index + 1)) {
                    return true;
                }
                board[row][col] = '.';
                rows[row][num] = cols[col][num] = blocks[block][num] = false;
            }
        }
        return false;
    }
}