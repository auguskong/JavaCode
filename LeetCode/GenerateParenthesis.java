//Check for the rules and focus on the execution order

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        if (n <= 0) {
            return result;
        }
        helper(n, result, new StringBuilder(), 0, 0);
        return result;
    }
    
    public void helper(int n, List<String> result, StringBuilder sb, int open, int close) {
        if (open == n && close == n) {
            result.add(sb.toString());
            return;
        }   
        if (open < n) {
            sb.append('(');
            helper(n, result, sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (close < open) {
            sb.append(')');
            helper(n, result, sb, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}