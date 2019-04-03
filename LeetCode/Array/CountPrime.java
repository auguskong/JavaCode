/**
* Date: 11/13/2018
* Type: Array
* Data Structure:
* Algorithm: Moore Voting Algorithm
*/

class Solution {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        boolean[] notPrime = new boolean[n]; // 使用notPrime可以省略初始化操作
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
            }
            for (int j = 2; i * j < n; j++) {
                notPrime[i * j] = true;
            }
        }

        return count;
    }
}