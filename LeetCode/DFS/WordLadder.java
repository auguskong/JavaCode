/**
* 解题思路：
* 1. 数据结构： Set + Queue  Set里面存来路(已经使用过的 word)是用来check word防止重复, queue 来进行遍历
* 2. Helper function:
* String replace(String s, int index, char c) {}
* getNextWords(String word, Set<String> dict) {}
*
* Steps:
* 1. check edge cases + create a new set
* 2. poll element from the queue and getNextWords from the current word
* 3. check if the nextword already exist,
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        Set<String> dict = new HashSet<String>();
        for (String word : wordList) {
            dict.add(word);
        }

        Queue<String> queue = new LinkedList<String>();
        HashSet<String> used = new HashSet<String>();

        queue.add(beginWord);
        used.add(beginWord);
        int steps = 1;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                List<String> nextWords = getNextWords(curr, dict);
                for (String next : nextWords) {
                    if (used.contains(next)) {
                        continue;
                    }
                    if (next.equals(endWord)) {
                        return steps;
                    }
                    used.add(next);
                    queue.add(next);
                }
            }
        }

        //can not find one
        return 0;
    }

    private String replace(String curr, int index, char c) {
        char[] chars = curr.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    private List<String> getNextWords(String curr, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < curr.length(); i++) {
                if (c == curr.charAt(i)) {
                    continue;
                }
                String nextWord = replace(curr, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }

        return nextWords;
    }
}