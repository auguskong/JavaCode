/**
* Date: 11/15/2018
* Type: DP
*
* 优化:
* dp[i] = cost[i] + min(dp[i- 1], dp[i - 2]) dp[i]表示为到第[i + 1]层的最小花费
* 当前层的楼梯是一定要爬的, 但是可以选择从第i - 1层爬上来或第i - 2层爬上来
*/
import java.lang.Math;

public class MinCostClimbingStairs {

    public int minCost(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int n = cost.length;
        int[] total = new int[n + 1];
        total[2] = Math.min(cost[0], cost[1]);
        for (int i = 3; i <= n; i++) {
            // dp[i] 表示到第[i]层的最小花费,
            // 需要定义数组长度为n + 1表示到达最顶层(需要考虑到最后一个元素)
            total[i] = Math.min(total[i - 1] + cost[i - 1],
                                total[i - 2] + cost[i - 2]);
        }

        return total[n];
    }

    /*
    total[i - 1] 用一个变量代替 oneStepBefore
    total[i - 2] 用一个变量代替 twoStepsBefore
    total = Math.min(oneStepBefore + cost[i - 1], twoStepsBefore + cost[i - 2]);
    oneStepBefore = total
    twoStepBefore = oneStepBefore
    */

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(new MinCostClimbingStairs().minCost(cost));
    }
}