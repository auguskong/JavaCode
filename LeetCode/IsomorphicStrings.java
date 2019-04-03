//Use array to do the match

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
			if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
				return false;
			}
			m1[s.charAt(i)] = count;
			m2[t.charAt(i)] = count;
            count++;
        } 
		return true;
	}
}