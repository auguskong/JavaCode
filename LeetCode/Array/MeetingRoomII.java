// 给出intervals列表,找出最少需要的会议室数量 == 找出最大的overlapping interval数量
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int len = intervals.length;
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < len; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // 保存的是最少需要的room数量而不是当前需要的room数量
        int rooms = 0;
        int pEnd = 0;
        for (int i = 0; i < len; i++) {
            //如果当前的会议开始比end的时间早，需要会议室
            if (starts[i] < ends[pEnd]) {
                rooms++;
            }
            //如果新的会议开始时间比end晚或刚好，可以直接使用当前空闲的会议室
            //不需要添加room,将结束的会议结束掉==移动pEnd指针到下一个会议结束时间
            else {
                pEnd++;
            }
        }
        return rooms;
    }
}