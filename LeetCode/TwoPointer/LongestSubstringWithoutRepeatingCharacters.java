/**
* Date: 11/19/2018
* Type: Two Pointers
* Data Structure: auxilary Hash Array
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        int max = 1;
        boolean[] hash = new boolean[256];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                if (!hash[s.charAt(j)]) {
                    // 一个小优化: 结合j++ 与数组索引
                    hash[s.charAt(j++)] = true;
                } else {
                    break;
                }
            }
            // 这里不需要进行j - i - 1因为j已经包含了 + 1
            max = Math.max(max, j - i);
            // j 这个指针并没有进行一个回退操作,所以只需要将i指针指向的字符复原即可
            hash[s.charAt(i)] = false;
        }

        return max;
    }
}