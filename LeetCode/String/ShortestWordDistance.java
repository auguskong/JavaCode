class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) {
            return 0;
        }

        int i = -1;
        int j = -1;
        // 不要随随便便赋值为 0
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < words.length; k++) {
            if (word1.equals(words[k])) {
                i = k;
            }
            // System.out.println("words[k]: " + words[k]);
            // System.out.println("word2: " + word2);
            if (words[k].equals(word2)) {
                j = k;
            }

            if (i != -1 && j != -1) {
                ans = Math.min(ans, Math.abs(i - j));
            }

        }

        return ans;
    }
}