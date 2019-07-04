class Solution {
    public void reverseString(char[] s) {
        if (s.length == 0) {
            return;
        }
        int size = s.length;
        int left = 0;
        int right = size - 1;
        while (left < right) {
            Character temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

        return;
    }
}