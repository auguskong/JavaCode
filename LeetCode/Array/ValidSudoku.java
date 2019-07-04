public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            boolean[] row = new boolean[9];
            boolean[] col = new boolean[9];

            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    if(row[num]) return false;

                    row[num] = true;
                }

                if(board[j][i] != '.'){
                    int num = board[j][i] - '1';
                    if(col[num]) return false;

                    col[num] = true;
                }
            }

            boolean[] cell = new boolean[9];
            for(int k = 0; k < 9; k++){
               int x = k / 3 + (i / 3) * 3;
               int y = k % 3 + (i % 3) * 3;

               if(board[x][y] != '.'){
                   int num = board[x][y] - '1';
                   if(cell[num]) return false;

                   cell[num] = true;
               }
            }
        }

        return true;
    }
}