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

class Solution {
    public int countPrimes(int n) {
        if (n < 0) {
            return -1;
        }
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                // System.out.println("i: " + i);
                count++;
                // 这里进行了优化操作, 第二个for循环的下限是 i,上限是 (n - 1) / i 注意有等于
                for (int j = i; j <= (n - 1) / i; j++) {
                    // System.out.println("i * j: " + (i * j));
                    notPrime[i * j] = true;
                }
            }
        }
        return count;
    }
}