/* BFS 层序遍历
先构造 公交站点 -> bus routes的映射,然后开始遍历Start站点的bus routes中经过的其它站点, 层层推进
下去,直到到达终点站或者全部遍历结束仍无法找到,返回 -1

*/
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes == null || routes.length == 0 || routes[0].length == 0) {
            return -1;
        }
        if (S == T) {
            return 0;
        }
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int times = 0;
        queue.add(S);
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                map.put(routes[i][j], buses);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            times++;
            for (int i = 0; i < size; i++) {
                int busStop = (int) queue.poll();
                List<Integer> buses = map.get(busStop);
                for (int route : buses) {
                    if (visited.contains(route)) {
                        continue;
                    }
                    visited.add(route);
                    for (int bus : routes[route]) {
                        if (bus == T) {
                            return times;
                        }
                        queue.add(bus);
                    }
                }
            }
        }
        return -1;
    }
}