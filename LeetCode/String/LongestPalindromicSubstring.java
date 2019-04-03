/**
* Date: 11/20/2018
* Type: String Palindrome
* Data Structure:
* Algorithm: 中心点枚举
*/

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        int left = 0;
        int right = n - 1;
        int longest = 0;
        int start = 0;
        // 因为本题是要求返回substring 所以需要求出substring的起点 和 终点
        for (int i = 0; i < n; i++) {
            int currLen = generatePalindrome(s, i, i);
            if (currLen > longest) {
                longest = currLen;
                // 注意这里是需要长度除 2
                start = i - currLen / 2;
            }

            currLen = generatePalindrome(s, i, i+1);
            if (currLen > longest) {
                longest = currLen;
                start = i - currLen / 2 + 1;
            }
        }
        return s.substring(start, start + longest);
    }

    private int generatePalindrome(String s, int left, int right) {
        int len = 0;

        // Option 1:
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                len += left == right ? 1 : 2;
                left--;
                right++;
            } else {
                // 注意当不满足条件时跳出循环
                break;
            }
        }

        // Option 2:
        // 优化: 将字符相等的判断写到while 循环之中
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            len += left == right ? 1 : 2;
            left--;
            right++;
        }

        return len;
    }
}