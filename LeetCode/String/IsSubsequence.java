/**
* 题目: 给两个String s 和 t, 判断s是不是t的subsequence
*/

// 我的解法
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (t == null || s.length() > t.length()) {
            return false;
        }
        Queue<Character> queue = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            queue.add(c);
        }
        int curr = 0;
        while (!queue.isEmpty() && curr < t.length()) {
            if (t.charAt(curr) == queue.peek()) {
                queue.poll();
            }
            curr++;
        }
        if (curr >= t.length() && !queue.isEmpty()) {
            return false;
        }

        return true;
    }
}

// 解法2: 双指针
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }
}

// 解法3:

class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c: s.toCharArray()){
            // indexOf(String str, int fromIndex) 从fromIndex 返回从fromIndex起始位置
            // 之后str第一次出现的index值
            index = t.indexOf(c, index + 1);
            if (index == -1){
                return false;
            }
        }
        return true;
    }
}