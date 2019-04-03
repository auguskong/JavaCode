public class CountTrailingZero {

    public static int countZeros(int num) {
        if (num < 10) {
            return 0;
        }

        String input = "" + num;
        int lo = 0;
        int hi = input.length() - 1;

        while (lo + 1 < hi) {

            int mid = lo + (hi - lo) / 2;
            int curr = Integer.parseInt(input.substring(lo, mid));
            if (curr / 10 == 0) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        System.out.println(lo);
        System.out.println(hi);
        if (input.charAt(lo) == '0' && input.charAt(hi) == '0') {
            int count = input.length() - lo;
            return count;
        }

        return input.length() - hi;

    }

    public static void main(String[] args) {
        int input = 12300020;
        int res = countZeros(input);

        System.out.println(res);
    }
}