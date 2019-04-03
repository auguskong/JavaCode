/**
* Date: 10/27/18
* Type: String
* Point: 26进制转换
*/

class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // sum = sum * 10 + chars[i] - '0' 一个简单的递归计算数值的操作
            res = res * 26 + (chars[i] - 'A' + 1);
        }

        return res;
    }
}