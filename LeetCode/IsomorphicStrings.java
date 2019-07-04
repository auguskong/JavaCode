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
            m1[s.charAt(i)]++;
            m2[t.charAt(i)]++;
        }
        return true;
    }
}

/*
"aba"
"baa"
s: -1 s['a'] = -1 s['a'] = 0
t: -1 t['b'] = -1 t['b'] = 0
s: -1 s['b'] = -1 s['b'] = 1
t: -1 t['a'] = -1 t['a'] = 1
s: 0  s['a'] =
t: 1  t['a'] =
*/


class Solution {
	public boolean isIsomorphic(String s, String t) {
		int[] m1 = new int[256];
		int[] m2 = new int[256];
		for (int i = 0; i < 256; i++) {
			m1[i] = m2[i] = -1;
		}
		int size = s.length();
        int count = 0;
		for (int i = 0; i < size; i++) {
			// must make sure that the relative location is the same
			if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
				return false;
			}
			// count变量的作用类似于一个时间戳
			m1[s.charAt(i)] = count;
			m2[t.charAt(i)] = count;
            count++;
        }
		return true;
	}
}

// 我的优化: 将timestamp赋值为1 不需要进行for 循环遍历赋值 -1
class Solution {
	public boolean isIsomorphic(String s, String t) {
		int[] m1 = new int[256];
		int[] m2 = new int[256];

		int size = s.length();
        int timestamp = 1;
		for (int i = 0; i < size; i++) {
			// must make sure that the relative location is the same
            // System.out.println("s: " + m1[s.charAt(i)]);
            // System.out.println("t: " + m2[t.charAt(i)]);
			if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
				return false;
			}
			m1[s.charAt(i)] = timestamp;
			m2[t.charAt(i)] = timestamp;
            timestamp++;
        }
		return true;
	}
}