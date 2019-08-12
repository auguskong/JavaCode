public class Solution {
    public List<String> generateAbbreviations(String word){
        List<String> res = new ArrayList<>();
        backtrack(res, word.toCharArray(), new StringBuilder(), 0, 0);
        return res;
    }

    private void backtrack(List<String> res, char[] word, StringBuilder sb, int count, int idx){
        if(idx == word.length){
            if(count > 0)
                sb.append(count);
            res.add(sb.toString());
            return;
        }

        int len = sb.length();
        // non abbr
        // step1: 将之前的数字加到当前位置
        // step2: 将现在的字符串加入sb 清空count并继续向下搜索
        if(count > 0) {
            sb.append(count);
        }
        sb.append(word[idx]);
        backtrack(res, word, sb, 0, idx+1);
        sb.setLength(len);

        // 跳过当前的character == 不进行append() 操作
        backtrack(res, word, sb, count+1, idx+1);
    }
}