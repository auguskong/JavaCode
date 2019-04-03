/**
* Date: 06/19/18
* Type: 计数型动态规划
* Point: 
* 考虑模式 抽象具体的结构
* 递归的思想： 左右divide conquer, 分别计数求加和
*
*/



class Solution {

        public int numTrees(int n) {
            int [] G = new int[n+1];
            G[0] = G[1] = 1;

            for(int i=2; i<=n; ++i) {
                for(int j=1; j<=i; ++j) {
                    G[i] += G[j-1] * G[i-j];
                }
            }

            return G[n];
        }

}