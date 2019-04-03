/**
* Date: 11/02/2018
* Type: Binary Search
* 数据结构: 无
* 错点: 数组下标标记错误
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = rows * cols - 1; //这里必须减一,以index作为结尾,而不是数组长度

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