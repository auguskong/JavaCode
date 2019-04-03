
public class PopularNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 7};
        int k = 4;
        System.out.println(k + ": " + new PopularNumber().findNumber(numbers, k));
    }

    // find a number appears more than n / k times
    // time complexity : O(k*log(n))
    public int findNumber(int[] numbers, int k) {

        int n = numbers.length;
        int minTimes = n / k + 1;
        for (int i = 0; i < n; i += minTimes) {
            int candidate = numbers[i];
            if (findLowerIndex(numbers, candidate + 1) - findLowerIndex(numbers, candidate) >= minTimes) {
                return candidate;
            }
        }
        return -1; // not found
    }

    // find the first index that numbers[i] >= target 相当于在这里找的是candidate number 的尾巴
    public int findLowerIndex(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (numbers[left] >= target) return left;
        if (numbers[right] >= target) return right;
        return -1;
    }
}