/* 题目描述:
给出一个数组，找到一个元素将数组分为左右两部分，使得左边的subarray中所有元素的值 小于等于 右边subarray
并且左边subarray的长度最短
*/

//我的答案 没有AC
class Solution {
    public int partitionDisjoint(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int largest = A[0];
        while (left < right) {
            System.out.println("left: " + left);
            System.out.println("right: " + right);
            largest = Math.max(largest, A[left]);
            if (largest <= A[right]) {
                right--;
            }
            else {
                left++;
            }
        }
        System.out.println("largest: " + largest);
        System.out.println("left: " + left);
        System.out.println("right: " + right);

        return A.length - right;
    }
}

class Solution {
    public int partitionDisjoint(int[] a) {
        int localMax = a[0], partitionIdx = 0, max = localMax;
        for (int i = 1; i < a.length; i++)
            if (localMax > a[i]) {
                localMax = max;
                partitionIdx = i;
            } else max = Math.max(max, a[i]);
        return partitionIdx + 1;
    }
}
