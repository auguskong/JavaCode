class Solution {
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }
        HashSet<String> set = new HashSet<String>();
        for (String email : emails) {
            int index = email.indexOf('@');
            String local = email.substring(0, index);
            String domain = email.substring(index + 1);
            // 重新构建apply rule之后的String, 然后保存到set之中进行保留
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < local.length(); i++) {
                if (local.charAt(i) == '+') {
                    break;
                }
                if (local.charAt(i) != '.') {
                    sb.append(local.charAt(i));
                }
            }
            String localShort = sb.toString();
            String emailShort = localShort + '@' + domain;
            if (!set.contains(emailShort)) {
                set.add(emailShort);
            }
        }
        return set.size();
    }
}