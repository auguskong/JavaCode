/*
难度在于用O(1) space来解决问题
*/
class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        String s1 = compress(sb1, S);
        //System.out.println(s1);
        String s2 = compress(sb2, T);
        //System.out.println(s2);
        return s1.equals(s2);
    }

    private String compress(StringBuilder sb, String S) {
       for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') {
                sb.append(S.charAt(i));
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }

    // O(n) time complexity  O(1) space complexity
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        while (true) {
            for (int back = 0; i >= 0 && (back > 0 || S.charAt(i) == '#'); --i)
                back += S.charAt(i) == '#' ? 1 : -1;
            for (int back = 0; j >= 0 && (back > 0 || T.charAt(j) == '#'); --j)
                back += T.charAt(j) == '#' ? 1 : -1;
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--; j--;
            } else
                return i == -1 && j == -1;
        }
    }

    // 双指针另一种解法
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) return S == T;
        int m = S.length(), n = T.length();
        int i = m - 1, j = n - 1;
        int cnt1 = 0, cnt2 = 0;//number of '#';
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (S.charAt(i) == '#' || cnt1 > 0)) {
                if (S.charAt(i) == '#') cnt1++;
                else cnt1--;
                i--;
            }
            while (j >= 0 && (T.charAt(j) == '#' || cnt2 > 0)) {
                if (T.charAt(j) == '#') cnt2++;
                else cnt2--;
                j--;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                return i == -1 && j == -1;
            }
        }
        return true;
    }

}

