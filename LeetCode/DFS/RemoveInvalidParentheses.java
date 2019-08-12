class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            }
            if (s.charAt(i) == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        Set<String> validStrs = new HashSet<>();
        getValidStrs(left, right, 0, 0, validStrs, new StringBuilder(), s);
        return new ArrayList<>(validStrs);
    }

    private void getValidStrs(int left, int right, int currentIdx, int balance, Set<String> validStrs, StringBuilder sb, String s) {
        for (int i = currentIdx; i < s.length(); i++) {
            if (balance < 0) return;

            char c = s.charAt(i);

            if (c == ')' && right != 0) {
                int currentLength = sb.length();
                getValidStrs(left, right - 1, i + 1, balance, validStrs, sb, s);
                sb.setLength(currentLength);
            } else if (c == '(' && left != 0) {
                int currentLength = sb.length();
                getValidStrs(left - 1, right, i + 1, balance, validStrs, sb, s);
                sb.setLength(currentLength);
            }

            sb.append(c);
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
        }

        if (left == 0 && right == 0 && balance == 0) {
            validStrs.add(sb.toString());
        }
    }
}
