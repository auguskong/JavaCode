/**
* Date: 11/15/2018
* 题目描述: 给出两个整数m 和 n，分别表示一个二维数组的行和列，和一个坐标的list，list当中表示的
* 点是用来执行addLand操作的位置，求返回一个list， 表示每一次addList操作之后得到的岛屿的个数。
*
* Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
* Output: [1,1,2,3]
*
1 0 0
0 0 0   Number of islands = 1
0 0 0

1 1 0
0 0 0   Number of islands = 1
0 0 0

1 1 0
0 0 1   Number of islands = 2
0 0 0

1 1 0
0 0 1   Number of islands = 3
0 1 0
*
* 思路: 每次添加岛屿之后check这个新的岛屿是否可以并入到已知的岛屿之中(判断root是否相同)
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class NumberOfIslandsII {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        List<Integer> result = new ArrayList<>();
        if(m <= 0 || n <= 0) return result;

        int count = 0;                      // number of islands
        int[] roots = new int[m * n];       // one island = one tree
        Arrays.fill(roots, -1);

        for(int[] p : positions) {
            int root = n * p[0] + p[1];     // assume new point is isolated island
            roots[root] = root;             // add new island
            count++;
            for(int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                int nb = n * x + y;
                if(x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) continue;

                int rootNb = findIsland(roots, nb);
                if(root != rootNb) {        // if neighbor is in another island
                    roots[root] = rootNb;   // union two islands
                    root = rootNb;          // current tree root = joined tree root
                    count--;
                }
            }
            result.add(count);
        }
        return result;
    }

    public int findIsland(int[] roots, int id) {
        while(id != roots[id]) id = roots[id];
        return id;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] positions = {{0,0}, {0,1}, {1,2}, {2,1}};
        List<Integer> res = new Solution().numIslands2(m, n, positions);
        System.out.println(res);
    }
}

// class Solution {
//     public List<Integer> numIslands2(int m, int n, int[][] positions) {
//       List<Integer> res = new LinkedList<>();
//       if (m <= 0 || n <= 0) { return res; }

//       int count = 0;
//       int[] roots = new int[m * n];   // 1D array of roots
//       int[] size  = new int[m * n];   // 1D array of size of each tree
//       Arrays.fill(roots, -1);         // Every position is water initially.
//       int[][] directions = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};

//       for (int[] p : positions) {
//         int island = p[0] * n + p[1];
//         roots[island] = island;     // Set it to be the root of itself.
//         size[island]++;
//         count++;

//         // Check four directions
//         for (int[] dir : directions) {
//           int x = p[0] + dir[0], y = p[1] + dir[1];
//           int neighbor = x * n + y;
//           // Skip when x or y is invalid, or neighbor is water.
//           if (x < 0 || x >= m || y < 0 || y >= n || roots[neighbor] == -1) { continue; }
//           int neighborRoot = find(neighbor, roots);
//           int islandRoot   = find(island, roots);
//           if (islandRoot != neighborRoot) {
//             // Union by size
//             if (size[islandRoot] >= size[neighborRoot]) {
//               size[islandRoot] += size[neighborRoot];
//               roots[neighborRoot] = islandRoot;
//             } else {
//               size[neighborRoot] += size[islandRoot];
//               roots[islandRoot] = neighborRoot;
//             }
//             count--;
//           }
//         }

//         res.add(count);
//       }

//       return res;
//     }

//     private int find(int id, int[] roots) {
//       if (roots[id] == id) { return id; }
//       else {
//         roots[id] = find(roots[id], roots);    // path compression
//         return roots[id];
//       }
//     }
// }


