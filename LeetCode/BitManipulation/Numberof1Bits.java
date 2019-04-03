/**
* Date: 11/02/2018
* Type: Bit Manipulation
* 21: 10101 101
*/


public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        //此处的起点位置应该是i = 0, >> 0最右边的位数起始
        for (int i = 0; i <= 31; i++) {
            count += (n >> i & 1) == 1 ? 1 : 0;
        }

        return count;
    }
}