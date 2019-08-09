// KNN 经典算法

class Solution {
    public static int[][] kClosest(int[][] points, int K) {
      if (points == null || points.length == 0 || points[0].length == 0) {
        return new int[][]{};
      }
      int[][] res = new int[K][2];
      int rows = points.length;
      int cols = points[0].length;
      int[] origin = {0,0};
      PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        public int compare(int[] pointA, int[] pointB) {
          if (calDistance(pointA, origin) > calDistance(pointB, origin)) {
            return -1;
          } else if (calDistance(pointA, origin) < calDistance(pointB, origin)) {
            return 1;
          } else {
            return 0;
          }
        }
      });
      for (int i = 0; i < rows; i++) {
        pq.add(points[i]);
        if (pq.size() > K) {
          pq.poll();
        }
      }

      for (int i = 0; i < K; i++) {
        int[] point = pq.poll();
        res[i] = point;
      }
      return res;
    }

    private static int calDistance(int[] pointA, int[] pointB) {
      return (pointA[0] - pointB[0]) * (pointA[0] - pointB[0]) + (pointA[1] - pointB[1]) * (pointA[1] - pointB[1]);
    }
}