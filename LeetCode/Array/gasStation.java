/**
* 题目: 给出两个数组 gas 和 cost gas中表示当前加油站可以加的油量, cost表示从当前加油站到
下一个加油站消耗的油量，求从哪一个加油站出发能够走完所有的加油站
*
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) {
            return -1;
        }
        int totalStations = gas.length;
        for (int i = 0; i < gas.length; i++) {
            int startStation = i;
            int curr = i;
            int count = 0;
            int tankGas = 0;
            // System.out.println("i: " + i);
            while (tankGas >= 0 && count < totalStations) {
                int currStation = curr % totalStations;
                tankGas = tankGas + gas[currStation] - cost[currStation];
                // System.out.println("tankGas: " + tankGas);
                // System.out.println("currStation: " + currStation);
                // System.out.println("count: " + count);
                curr++;
                count++;
            }
            if (count == totalStations && tankGas >= 0) {
                return startStation;
            }
        }

        return -1;
    }
}


//假设一
// If car starts at A and can not reach B.(B is the first station that A can not reach.)
// then start from any station between A and B, we can not reach B.
//证明：对于AB中的任意一个站C：由于A可以到达C，从A出发到达C时，tank>=0,接着从C往B走，无法成功到达B。
//那么如果直接从C出发，tank=0，更不可能到达B了。所以AB中的任意一站C是不可能作为起点的

//假设二
// If the total number of gas is bigger than the total number of cost. There must be no solution!
//证明：从任何一个gas station绕行一圈后，（gas-cost）求和是一样的。如果求和小于0，至少说明无法到达gas station 0（当然，也可能早就没油停车了）,即无法完成环路
public int canCompleteCircuit(int[] gas, int[] cost) {
    int sumGas = 0;
    int sumCost = 0;
    int start = 0;//完成环路的起点位置
    int tank = 0;//车油箱中的油
    for (int i = 0; i < gas.length; i++) {
        sumGas += gas[i];
        sumCost += cost[i];
        tank += gas[i] - cost[i];//每次从i站到i+1站，油箱油量增加 gas[i]-cost[i]
        if (tank < 0) {//油不够用，说明从start到不了i+1站（注意，这是start出发，第一次到达不了的站）
            //此时，start到不了i+1站， start+1,start+2,...i站同样到不了i站。所以就将start,start+1,start+2,....i站都排除了。
            //所以，考虑新的可能的起点start=i+1,同时清空油箱。
            start = i + 1;
            tank = 0;
        }
    }
    if(sumGas < sumCost) {//gas station的总油量小于总cost
        return -1;
    }

    //题目中说了，解是唯一的。下面证明start是可行解：
    //首先： 从start到第0站是可行的（上面的for循环判断了）。此时tank = sum1, 且sum1>0
    //其次： 从0站出发到达start站是不行的，从0站出发到达start站时tank = sum2, 且sum2<0
    //而由于sumGas>=sumCost,所以sum1+sum2>=0,即sum1-|sum2|>=0,也就证明了：
    //从start站出发，到达最后一站（此时tank=sum1）,然后再继续从0站到达start站是可行的。
    //那么当在0站，tank=sum1时0,从0站到达start的过程中，有没有可能欠油呢?不可能！
    //0站tank=sum1, 假如在某站i（i=1,2,..start-1）时最后一次欠油，由于最终在到达start站后tank>=0,那么说明在i站出发必能到达start站，这与假设一矛盾。所以不存在欠油的时候
    //所以start是可行解
    return start;
}