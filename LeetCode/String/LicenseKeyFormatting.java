class Solution {
    public String licenseKeyFormatting(String S, int K) {
        char[] chars = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != '-') {
                count++;
                sb.append(chars[i]);
                if (count > 1 && (count + 1) % (K + 1) == 0) {
                    sb.append('-');
                } else {
                    sb.append("");
                }
            }
        }

        return sb.reverse().toString().toUpperCase();
    }

    StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
}

/*
K 是最小分组的长度 从后向前 如果遇到了小写就直接
小写变大写
从后向前进行
*/