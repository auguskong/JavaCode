class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        int digit = 0;
        while (set.add(n)) {
            res = 0;
            while (n > 0) {
                digit = n % 10;
                // System.out.println("digit: " + digit);
                res += digit * digit;
                n = n / 10;
            }
            if (res == 1) {
                return true;
            } else {
                n = res;
            }
        }
        return false;
    }
}