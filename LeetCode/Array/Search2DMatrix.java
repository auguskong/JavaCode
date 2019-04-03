/**
* Date: 10/31/2018
* Type: Bianry Search
* 数据结构:
* 思路: 将二维数组拉平直接当做一维数组来做
*/

/*
* 错点:
* 1. 数组初始化语法错误 return {-1, -1}/return new int[] -> return new int[]{-1, -1}
* 2. 重复定义变量 line24: int start  line54: int start
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = rows * cols - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            }
            else if (matrix[mid / cols][mid % cols] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[start / cols][start % cols] == target || matrix[end / cols][end % cols] == target) {
            return true;
        }
        return false;
    }
}