
// 使用int[] map数组来代替hashmap数据结构
class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0) return "";
        int minL = 0, minR = 0;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int[] map = new int[256];
        for(char c : t.toCharArray()) map[c]++;
        int count = t.length();

        while(right < s.length()){
            char cur = s.charAt(right);
            if(map[cur] > 0) count--;
            map[cur]--;
            while(count == 0 && left <= right){
                if(right - left + 1 < minLen){
                    minL = left;
                    minR = right;
                    minLen = right - left + 1;
                }
                char leftChar = s.charAt(left);
                map[leftChar]++;
                if(map[leftChar] > 0) count++;
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minL, minR+1);
    }
}