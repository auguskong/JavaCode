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

// DFS solution
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        Map<String, Boolean> cache = new HashMap<>();
        return recurFind(set, s, cache);
    }

    private boolean recurFind(Set<String> set, String s, Map<String, Boolean> cache) {
        if (cache.containsKey(s)) return cache.get(s);
        if (set.contains(s)) return true;
        for (int i = 1; i < s.length(); i++) {
            if (set.contains(s.substring(0, i)) && recurFind(set, s.substring(i, s.length()), cache)) {
                cache.put(s, true);
                return true;
            }
        }
        cache.put(s, false);
        return false;
    }
}
