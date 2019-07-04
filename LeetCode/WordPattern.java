// 和IsomorphicString题目很像 把字符与字符的对应关系换成了字符与字符串的对应

// 我的答案
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i)) &&
                !map.containsValue(words[i])) {
                // 这里为了保证是1 对 1的对应关系,同时check了map的key 和 value两个变量
                map.put(pattern.charAt(i), words[i]);
            } else {
                String match = map.get(pattern.charAt(i));
                if (match == null || !match.equals(words[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}