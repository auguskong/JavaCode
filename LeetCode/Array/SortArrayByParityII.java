/**
* Date: 10/31/2018
* Type: Array处理 Two Pointers
* 数据结构:
* 思路: 两根指针分别指向奇数位置 和 偶数位置
*/

/*
* 错点:
* 1. 思路错误,没有使用两根指针而只用了一根指针
* 2. 数组越界错误 while (i < n) {i += 2} 当 i = n - 1时进入loop n - 1 + 2 = n + 1越界
* 3. while loop当中应该嵌套while loop来进行操作
*/

// 如果只用一个指针来找的话，当奇数在数组偶数位连续多次出现时，指针只能够指向最后一个不符合要求的数字
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int lastOdd = -1;
        int lastEven = -1;
        for (int i = 0; i < A.length; i++) {
            System.out.println("before: " + lastOdd + " " + lastEven);
            if (A[i] % 2 == 0 && i % 2 != 0) {
                if (lastEven >= 0) {
                    swap(A, lastEven, i);
                    lastEven = -1;
                } else {
                    lastOdd = i;
                }
            }
            else if (A[i] % 2 != 0 && i % 2 == 0) {
                if (lastOdd >= 0) {
                    swap(A, lastOdd, i);
                    lastOdd = -1;
                } else {
                    lastEven = i;
                }
            }
            System.out.println("after: " + lastOdd + " " + lastEven);
        }
        return A;
    }

    private void swap (int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int i = 0;
        int j = 1;

        while (i < n && j < n) {
            while (i < n && A[i] % 2 == 0) {
                i = i + 2;
            }
            while (j < n && A[j] % 2 == 1) {
                j = j + 2;
            }
            if (i < n && j < n) {
                swap(A, i, j);
            }
        }
        return A;
    }

    private void swap (int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}