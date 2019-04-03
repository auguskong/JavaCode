/**
* Date: 06/15/18
* Note: 1. Set是抽象类，不能声明为Set<String>类型
*       2. 字符串比较使用equals()方法
*       3. char先转int做变换之后 再转回char  - '0'  + '0'
*/



class Solution {
    public int openLock(String[] deadends, String target) {
        
        String start = "0000";
        int numEnds = deadends.length;
        Set<String> deadSet = new HashSet<>();
        for (String str : deadends) {
            if (str.equals(start)){
                return -1;
            }
            deadSet.add(str);
        }
        
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        set.add(start);
        int result = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                String curr = queue.poll();
            
                if (curr.equals(target)) {
                    return result;
                }
                    
                for (int i = 0; i < 4; ++i) {
                    String next = curr.substring(0, i) + (char)((curr.charAt(i) - '0' + 9) % 10 + '0') + curr.substring(i + 1);
                    if (!set.contains(next) && !deadSet.contains(next)) {
                        queue.offer(next);
                        set.add(next);
                    }
                    
                    next = curr.substring(0, i) + (char)((curr.charAt(i) - '0' + 1) % 10 + '0') + curr.substring(i + 1);
                    if (!set.contains(next) && !deadSet.contains(next)) {
                        queue.offer(next);
                        set.add(next);
                    }
                }      
            }
            result++;
        }
        return -1;
    }
}
