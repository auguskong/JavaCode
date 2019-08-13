
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        String[] letters = new String[]{"", "","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(res, "", digits, letters, 0);
        return res;
    }
    // 直接使用 curr String类型来进行拼接 就不需要进行backtracking操作了 因为String is immutable
    // 在不同的function 之间不共享
    private void dfs(List<String> res, String curr, String digits, String[] letters, int i) {
        if (curr.length() == digits.length()) {
            res.add(curr);
            return;
        }
        String letter = letters[digits.charAt(i) - '0'];
        for (Character c : letter.toCharArray()) {
             dfs(res, curr + c, digits, letters, i + 1);
        }
    }
}