//Use array to do the match

// 我的答案哪里出问题了?

/*
"aba"
"baa"
s: -1 s['a'] = -1 s['a'] = 0
t: -1 t['b'] = -1 t['b'] = 0
s: -1 s['b'] = -1 s['b'] = 0
t: -1 t['a'] = -1 t['a'] = 0
s: 0  s['a'] = 0
t: 0  t['a'] = 0
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for (int i = 0; i < s.length();i++) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }
            m1[s.charAt(i)]++; // 这里出问题了 直接++ 可能基准不同
            m2[t.charAt(i)]++;
        }
        return true;
    }
}
// =============================================================
// 正确答案: 考虑了字符出现的顺序(用i来进行定位标记) 以及出现的次数
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for (int i = 0; i < s.length();i++) {
            System.out.printf("s.charAt(%d): %c,  t.charAt(%d): %c \n", i, s.charAt(i), i, t.charAt(i));
            System.out.printf("m1[%c]: %d m2[%c]: %d \n", s.charAt(i), m1[s.charAt(i)], t.charAt(i), m2[t.charAt(i)]);
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }
            m1[s.charAt(i)] = i;
            m2[t.charAt(i)] = i;

        }
        return true;
    }
}
Your input
"aba"
"baa"
stdout
s.charAt(0): a,  t.charAt(0): b
m1[a]: 0 m2[b]: 0
s.charAt(1): b,  t.charAt(1): a
m1[b]: 0 m2[a]: 0
s.charAt(2): a,  t.charAt(2): a
m1[a]: 0 m2[a]: 1
Output
false
Expected
false

//===============================================================
// 错误答案： 没有考虑字母出现的顺序 只要字符在两个字符串中出现的次数相等就可以
Your input
"abamnmm"
"baanmma"
stdout
s.charAt(0): a,  t.charAt(0): b
m1[a]: 0 m2[b]: 0
s.charAt(1): b,  t.charAt(1): a
m1[b]: 0 m2[a]: 0
s.charAt(2): a,  t.charAt(2): a
m1[a]: 1 m2[a]: 1
s.charAt(3): m,  t.charAt(3): n
m1[m]: 0 m2[n]: 0
s.charAt(4): n,  t.charAt(4): m
m1[n]: 0 m2[m]: 0
s.charAt(5): m,  t.charAt(5): m
m1[m]: 1 m2[m]: 1
s.charAt(6): m,  t.charAt(6): a
m1[m]: 2 m2[a]: 2
Output
true
Expected
false
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for (int i = 0; i < s.length();i++) {
            System.out.printf("s.charAt(%d): %c,  t.charAt(%d): %c \n", i, s.charAt(i), i, t.charAt(i));
            System.out.printf("m1[%c]: %d m2[%c]: %d \n", s.charAt(i), m1[s.charAt(i)], t.charAt(i), m2[t.charAt(i)]);
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                return false;
            }
            m1[s.charAt(i)]++;
            m2[t.charAt(i)]++;

        }
        return true;
    }
}

Your input
"aba"
"baa"
stdout
s.charAt(0): a,  t.charAt(0): b
m1[a]: 0 m2[b]: 0
s.charAt(1): b,  t.charAt(1): a
m1[b]: 0 m2[a]: 0
s.charAt(2): a,  t.charAt(2): a
m1[a]: 1 m2[a]: 1
Output
true
Expected
false

//=====================================================================



class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            if (!map.containsKey(sChar) && !map.containsValue(tChar)) {
                map.put(sChar, tChar);
            } else {
                Character match = map.get(sChar);
                if (match == null || match != tChar) {
                    return false;
                }
            }
        }
        return true;
    }
}
