// 找4个方向的词里面是否存在一个word

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> founds = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (int k = 0; k < words.length; k++) {
                    if (dfs(board, i, j, 0, words[k])) {
                        founds.add(words[k]);
                        words[k] = null;
                    }
                }

            }
        }

        return founds;
    }

    private boolean dfs(char[][] board, int i, int j, int index, String word) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length) return false;
        if (j < 0 || j >= board[0].length) return false;
        if (word.charAt(index) != board[i][j]) return false;

        board[i][j] = '#';
        boolean found = (dfs(board, i + 1, j, index + 1, word) ||
                         dfs(board, i - 1, j, index + 1, word) ||
                         dfs(board, i, j + 1, index + 1, word) ||
                         dfs(board, i, j - 1, index + 1, word));
        board[i][j] = word.charAt(index); //复原字符

        return found;
    }
}