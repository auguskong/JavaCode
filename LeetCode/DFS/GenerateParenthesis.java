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

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), n, n);
        return res;
    }

    private void helper(List<String> res, StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        int length = sb.length();
        if (left > 0) {
            sb.append('(');
            helper(res, sb, left - 1, right);
            sb.setLength(length);
        }
        // 必须要加 left < right 的限定条件 否则会出现无效的结果 比如 ‘)))(((’
        if (left < right) {
            sb.append(')');
            helper(res, sb, left, right - 1);
            sb.setLength(length);
        }
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), n, n);
        return res;
    }

    private void helper(List<String> res, StringBuilder sb, int left, int right) {
        indent(sb.length());
        System.out.println("left: " + left + " right: " + right + " sb: " + sb.toString());
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        int length = sb.length();
        if (left > 0) {
            sb.append('(');
            helper(res, sb, --left, right);
            sb.setLength(length);
        }
        if (right > left) {
            sb.append(')');
            helper(res, sb, left, --right);
            sb.setLength(length);
        }
    }
    private static void indent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("   ");
        }
    }
}

left: 3 right: 3 sb:
   left: 2 right: 3 sb: (
      left: 1 right: 3 sb: ((
         left: 0 right: 3 sb: (((
            left: 0 right: 2 sb: ((()
               left: 0 right: 1 sb: ((())
                  left: 0 right: 0 sb: ((()))
         left: 0 right: 2 sb: (()
            left: 0 right: 1 sb: (())
               left: 0 right: 0 sb: (()))
      left: 1 right: 2 sb: ()
         left: 0 right: 2 sb: ()(
            left: 0 right: 1 sb: ()()
               left: 0 right: 0 sb: ()())
         left: 0 right: 1 sb: ())
            left: 0 right: 0 sb: ()))
   left: 2 right: 2 sb: )
      left: 1 right: 2 sb: )(
         left: 0 right: 2 sb: )((
            left: 0 right: 1 sb: )(()
               left: 0 right: 0 sb: )(())
         left: 0 right: 1 sb: )()
            left: 0 right: 0 sb: )())
      left: 1 right: 1 sb: ))
         left: 0 right: 1 sb: ))(
            left: 0 right: 0 sb: ))()
         left: 0 right: 0 sb: )))

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), n, n);
        return res;
    }

    private void helper(List<String> res, StringBuilder sb, int left, int right) {
        indent(sb.length());
        System.out.println("left: " + left + " right: " + right + " sb: " + sb.toString());
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        int length = sb.length();
        if (left > 0) {
            sb.append('(');
            helper(res, sb, left - 1, right);
            sb.setLength(length);
        }
        if (right > left) {
            sb.append(')');
            helper(res, sb, left, right - 1);
            sb.setLength(length);
        }
    }
    private static void indent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("   ");
        }
    }
}

// 进行memory 优化的写法
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}