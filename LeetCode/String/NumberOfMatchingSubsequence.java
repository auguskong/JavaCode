
// 我的解法: 遍历words数组中的所有String, 然后调用isSubsequence来进行判断
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int count = 0;
        for (String word : words) {
            if (isSubsequence(word, S)) {
                count++;
            }
        }
        return count;
    }

    private boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c: s.toCharArray()){
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}

// 解法2: 并行遍历words中的所有word 需要import java.text.StringCharacterIterator
public int numMatchingSubseq(String S, String[] words) {
    List<StringCharacterIterator>[] waiting = new List[128];
    for (int c = 0; c <= 'z'; c++)
        waiting[c] = new ArrayList();
    for (String w : words)
        waiting[w.charAt(0)].add(new StringCharacterIterator(w));
    for (char c : S.toCharArray()) {
        List<StringCharacterIterator> advance = waiting[c];
        waiting[c] = new ArrayList();
        for (StringCharacterIterator it : advance)
            waiting[it.next() % it.DONE].add(it);
    }
    return waiting[0].size();
}