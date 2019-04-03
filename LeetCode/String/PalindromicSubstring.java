/**
* Date: 02/08/2019
* Type: 中心点枚举算法
*
*/

class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            countPalindrome(s, i, i);
            countPalindrome(s, i, i + 1);
        }

        return count;
    }

    private void countPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
    }
}
