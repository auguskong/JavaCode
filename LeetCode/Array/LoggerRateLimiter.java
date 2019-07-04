/*
题目描述: 有不断进入的 message 以及每个message对应时间戳, 实现一个数据结构来判断当一个message
在10s之内出现过就不打印，没出现过就打印
*/


// HashMap的解法 key: message value: 该message下次可以打印的最近时间 在该题目中是 10s后
// 坑: 如果key: message value: 当前出现时间 那么就不能使用getOrDefault(message, 0)命令
// 因为会错判第一次出现的情况
// 可能存在的问题 内存不足 有太多的key-value pair
class Logger {
    private Map<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        int threshold = map.getOrDefault(message, timestamp);
        if (threshold <= timestamp) {
        // contains two scenarios: message hasn't occurred & timeout
            map.put(message, timestamp + 10);
            return true;
        }
        return false;
    }
}

// 我的答案:
class Logger {
    HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        }
        if (timestamp - map.getOrDefault(message, 0) < 10) {
            return false;
        }
        map.put(message, timestamp);
        return true;
    }
}

// Algo thinking Queue
// time = O(N)

class TimeMsg {
    int timestamp;
    String msg;
    public TimeMsg(int timestamp, String msg) {
        this.timestamp = timestamp;
        this.msg = msg;
    }
}

/** Initialize your data structure here. */
private static final int MAX_TIME_WINDOW = 10;

Queue<TimeMsg> msgQueue;
public Logger() {
    msgQueue = new LinkedList<>();
}

/** Returns true if the message should be printed in the given timestamp, otherwise returns false.
    If this method returns false, the message will not be printed.
    The timestamp is in seconds granularity. */
public boolean shouldPrintMessage(int timestamp, String message) {

    while (!msgQueue.isEmpty() && timestamp - msgQueue.peek().timestamp >= MAX_TIME_WINDOW) {
        msgQueue.poll();
    }

    Iterator<TimeMsg> iter = msgQueue.iterator();
    while (iter.hasNext()) {
        TimeMsg tm = iter.next();
        if (tm.msg.equals(message)) return false;
    }

    msgQueue.offer(new TimeMsg(timestamp, message));

    return true;
}

class TMessage {
    String message;
    int timestamp;
    public TMessage(String message, int timestamp) {
        // 这里必须要加this 关键字进行修饰
        this.message = message;
        this.timestamp = timestamp;
    }
}
class Logger {

    /** Initialize your data structure here. */
    Queue<TMessage> mesQueue;
    public Logger() {
        mesQueue = new LinkedList<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!mesQueue.isEmpty() && timestamp -
               mesQueue.peek().timestamp >= 10) {
            mesQueue.poll();
        }
        Iterator<TMessage> ite = mesQueue.iterator();

        while (ite.hasNext()) {
            if (ite.next().message.equals(message)) {
                return false;
            }
        }
        mesQueue.offer(new TMessage(message, timestamp));
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */