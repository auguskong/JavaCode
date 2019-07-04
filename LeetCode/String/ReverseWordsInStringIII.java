class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            System.out.println("i at for start: " + i);
            if (s.charAt(i) == ' ') {
                sb.append(' ');
                continue;
            } else {
                // 先将这个分割单元扫一遍到该单元最后一个字符
                int end = i;
                while (end < s.length() && s.charAt(end) != ' ') {
                    end++;
                }
                // 此时end是指向空格的位置 所以起点应该为end - 1指向空格前的第一个字符串
                for (int j = end - 1; j >= i; j--) {
                    sb.append(s.charAt(j));
                }
                System.out.println("end: " + end);
                i = end - 1;
                System.out.println("i at for end: " + i);
            }
        }
        return sb.toString();
    }
}