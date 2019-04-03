/**
* Date: 11/20/2018
* Type: String Palindrome
* Data Structure:
* Algorithm: 中心点枚举
* 类似题目: LongestPalindromicSubstring, Palindromic Substring
*/


class Solution {
    public static int countPalindromes(String a) {
        int globalCount = a.length();
        for (int mid = 1; mid < a.length() - 1; mid++) {
            int count = 0;

            int low = mid - 1;
            int high = mid + 1;
            while (low >= 0 && high < a.length() && a.charAt(low--) == a.charAt(high++))
                count++;

            globalCount += count;
            count = 0;

            low = mid - 1;
            high = mid;
            while (low >= 0 && high < a.length() && a.charAt(low--) == a.charAt(high++))
                count++;

            globalCount += count;
        }

        return globalCount;
    }
}

class Solution {
    public int countSubstrings(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += extractPalindrome(s, i, i);
            sum += extractPalindrome(s, i, i + 1);
        }

        return sum;
    }

    /**
    * @param
    * @return number of palindrome with center of (left + right / 2)
    */
    private int extractPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}