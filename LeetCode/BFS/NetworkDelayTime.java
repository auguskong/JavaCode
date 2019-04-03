/**
* Date: 06/17/18
* Author: Augus Kong
* 
* Point: compare(Integer c1, Integer c2) {...}
*
*/

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times.length == 0 || times[0].length == 0) {
            return -1;
        }
        int[][] grid = new int[N + 1][N + 1];
        int[] res = new int[N + 1];
        int MAX = 100 * 101;
        
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                grid[i][j] = MAX;
            }
        }
        for (int[] curEdge : times) {
            grid[curEdge[0]][curEdge[1]] = curEdge[2];
        }
        Arrays.fill(res, MAX);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(N, new Comparator<Integer>() {
            @Override
            public int compare(Integer c1, Integer c2) {
                return res[c1] - res[c2];
            }
        });
        minHeap.add(K);
        res[K] = 0;
        while (!minHeap.isEmpty()) {
            int node = minHeap.poll();
            for (int i = 0; i <= N; i++) {
                int weight = grid[node][i];
                if (weight != MAX && res[i] > res[node] + weight) {
                    res[i] = res[node] + weight;
                    minHeap.add(i);
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (res[i] == MAX) {
                return -1;
            }
            count = Math.max(count, res[i]);
        }
        
        return count;
    }
}