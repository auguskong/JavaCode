class Solution {
    public boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (Character c : chars) {
            if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}