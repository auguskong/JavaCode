/**
* Type: String
* Date: 02/06/2019
*
*/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, res, new ArrayList<String>(), 0);
        return res;
    }

    private void dfs(String s, List<List<String>> res, List<String> cur, int start) {
        if (s.length() == start) {
            res.add(new ArrayList<>(cur));
            return;
        }
        // backtracking 的添加条件 作为isPalindrome
        for (int i = start + 1; i <= s.length(); i++) {
            if (isPalindrome(s, start, i - 1)) {
                cur.add(s.substring(start, i));
                dfs(s, res, cur, i);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i , int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}

//=======================================================================
//DP 版本的答案 将isPalindrome信息存到DP数组之中来避免isPalindrome多次调用进行优化
//=======================================================================
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> rst = new ArrayList<List<String>>();

        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                // ？？？: 这里的i - j <= 2是什么意思?
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[i - 1][j + 1]))
                    dp[i][j] = dp[j][i] = true;
            }
        }

        dfs(rst, new ArrayList<String>(), s, 0, dp);

        return rst;
    }

    private void dfs(List<List<String>> rst, List<String> list, String s, int index, boolean[][] dp){
        if(index == s.length()){
            rst.add(new ArrayList<String>(list));
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(!dp[i][index]) continue;

            String substr = s.substring(index, i + 1);
            list.add(substr);
            dfs(rst, list, s, i + 1, dp);
            list.remove(list.size() - 1);
        }
    }
}