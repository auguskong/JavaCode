/*
IP的命名规则
1. 不能有leading 0, 即'01' '022' isValid()
2. 取值范围必须是在[0,255] isValid()
3. 必须要有4个部分组成 ipIndex
*/
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return res;
        }
        dfs(res, s, new StringBuilder(), 0, 0);
        return res;
    }

    private void dfs(List<String> res, String s, StringBuilder sb, int strIndex, int ipIndex) {
        if (ipIndex > 4) {
            return;
        }
        if (ipIndex == 4 && strIndex == s.length()) {
            sb.setLength(sb.length() - 1); // remove the last dot
            res.add(sb.toString());
            return;
        }
        int length = sb.length();
        for (int i = 1; i <= 3; i++) {
            if (strIndex + i <= s.length()) {
                String subStr = s.substring(strIndex, strIndex + i);
                //System.out.println(subStr);
                if (isValidIP(subStr)) {
                    sb.append(subStr);
                    sb.append('.');
                    dfs(res, s, sb, strIndex + i, ipIndex + 1);
                }
                sb.setLength(length);
            }
        }
    }

    private boolean isValidIP(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        int num = Integer.parseInt(s);
        if (num > 0 && num <= 255) {
            return true;
        }
        return false;
    }
}