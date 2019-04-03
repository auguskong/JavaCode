/* Recursive BFS search
board[i][j] = "#" mark
backtrack for true/false result
*/
public class Solution {
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0) {
			return false;
		}
		if (word.length() == 0) {
			return true;
		}
    //search the whole board
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					boolean res = find(board, i, j, word, 0);
					if (res) {
						return true;
					}
				}
			}
		}

		return false;
    }

    private boolean find(char[][] board, int i, int j, String word, int start) {
        //already find the result
        if (start == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)) {
            return false;
        }

        board[i][j] = '#'; //mark it
        boolean res = find(board, i - 1, j, word, start + 1)
                                    || find(board, i, j - 1, word, start + 1)
                                    || find(board, i + 1, j, word, start + 1)
                                    || find(board, i, j + 1, word, start + 1);

        //Q: what is this statement used for ?	A: cancel the mark - backtrack
        board[i][j] = word.charAt(start);
        return res;
    }
}

class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;
        char[] chars = word.toCharArray();
        boolean isFound = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (chars[0] == board[i][j]) {
                    isFound = Search(board, chars, i, j, 0);
                    if (isFound) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean Search(char[][] board, char[] chars, int row, int col, int curr) {
        if (curr >= chars.length) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        char temp = board[row][col];
        if (chars[curr] == board[row][col]) {
            board[row][col] = '#';
            if (Search(board, chars, row + 1, col, curr + 1) ||
                Search(board, chars, row - 1, col, curr + 1) ||
                Search(board, chars, row, col + 1, curr + 1) ||
                Search(board, chars, row, col - 1, curr + 1)) {
                return true;
            }
        }
        board[row][col] = temp;
        return false;
    }
}

