

// 我的答案: 用Queue来记录所有的元素
class MovingAverage {
    /** Initialize your data structure here. */
    double sum = 0;
    int total = 0;
    Queue<Integer> queue = new LinkedList<Integer>();

    public MovingAverage(int size) {
        total = size;
    }

    public double next(int val) {
        if (queue.size() < total) {
           queue.add(val);
           sum += val;
           return sum / queue.size();
        }
        else {
            int oldest = queue.poll();
            queue.add(val);
            sum = sum + val - oldest;
            return sum / queue.size();
        }
    }
}

// 别人的答案: 用一个数组来存 然后用 % 符号做循环buffer操作
public class MovingAverage {
    private int [] window;
    private int n, insert;
    private long sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
        insert = 0;
        sum = 0;
    }

    public double next(int val) {
        if (n < window.length)  n++;
        sum -= window[insert];
        sum += val;
        window[insert] = val;
        insert = (insert + 1) % window.length;

        return (double)sum / n;
    }
}