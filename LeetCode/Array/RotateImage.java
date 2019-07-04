//You are given an n x n 2D matrix representing an image.
//Rotate the image by 90 degrees (clockwise).

class Solution {
  public void rotate(int[][] matrix) {
    //在leetcode里这题是NxN的矩阵
    int n= matrix.length;
    //一个4x4的矩阵是内外2层 那么一个NxN的矩阵 layer的数量是N/2
    for(int layer = 0; layer < n/2; layer++){ //外循环 层数变大
      int first = layer;
      int last = n - 1 - layer;//下标 -layer
      for(int i = first;i < last; i++){   //first是层数,i是本层中的位置
        int offset = i - first;//offset是位移的意思
        //储存上边
        int top = matrix[first][i];
        //上 = 左
        matrix[first][i] = matrix[last-offset][first];
        //左 = 下
        matrix[last-offset][first] = matrix[last][last-offset];
        //下 = 右
        matrix[last][last-offset] = matrix[i][last];
        //右 = 上
        matrix[i][last] = top;
      }
    }
  }
}