class Solution {
    public String addBinary(String a, String b) {

        if (a == null || a.length() == 0) {
            return b;
        }

        if (b == null || b.length() == 0) {
            return a;
        }

        int pA = a.length() - 1;
        int pB = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        // 如果是正序相加,从后向前依次进位 多余的1不能append到String之前
        // 使用倒序相加来解决进位carry 再利用的问题
        while (pA >= 0 || pB >= 0) {
            int sum = carry;
            if (pA >= 0) {
                sum += a.charAt(pA--) - '0';
            }
            if (pB >= 0) {
               sum += b.charAt(pB--) - '0';
            }
            carry = sum / 2;
            sb.append(sum % 2);
        }
        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}