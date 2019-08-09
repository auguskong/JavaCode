/*
IP的命名规则
1. 不能有leading 0, 即'01' '022' isValid()
2. 取值范围必须是在[0,255] isValid()
3. 必须要有4个部分组成 ipIndex
*/
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), s, 0, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, String s, int strIndex, int ipIndex) {
        if (ipIndex > 4) {
            return;
        }
        if (ipIndex == 4 && strIndex == s.length()) {
            sb.setLength(sb.length() - 1); //需要把多加的那个'.'去掉
            res.add(sb.toString());
            return;
        }
        int len = sb.length();
        for (int i = 0; i < 3; i++) {
            if (strIndex + i < s.length()) {
                String subStr = s.substring(strIndex, strIndex + i + 1);
                if (isValid(subStr)) {
                    sb.append(subStr);
                    sb.append('.');
                    dfs(res, sb, s, strIndex + i + 1, ipIndex + 1);
                    sb.setLength(len);
                }
            }
        }
    }

    private boolean isValid(String str) {
        if (str.charAt(0) == '0') {
            return str.equals("0");
        }
        int num = Integer.parseInt(str);
        if (num > 0 && num <= 255) {
            return true;
        }
        return false;
    }
}