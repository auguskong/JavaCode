public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean[][] canBreak = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = i; j >= 0; j--){
                String str = s.substring(j, i + 1);
                if(wordDict.contains(str)) {
                    canBreak[i][j] = canBreak[j][i] = true;
                }
                if(j > 0 && canBreak[j][i] && canBreak[0][j - 1]) {
                    canBreak[0][i] = canBreak[i][0] = true;
                }
            }
        }

        return canBreak[0][n - 1];
    }
}

class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean[] canBreak = new boolean[n + 1];
        canBreak[0] = true;

        for(int j = 1; j <= n; j++){
            for(int i = j; i >= 0; i--){
                if(!canBreak[i]) continue;
                String str = s.substring(i, j);
                if(wordDict.contains(str)) {
                    canBreak[j] = true;
                }
            }
        }

        return canBreak[n];
    }
}