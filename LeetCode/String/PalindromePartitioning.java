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