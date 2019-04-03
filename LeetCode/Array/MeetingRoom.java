/*
给出一些时间序列,包含起点和终点,判断interval之间是否有overlap,直接排序判断start < end
*/
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null) {
            return false;
        }
        Arrays.sort(intervals, (i1, i2) -> (i1.start - i2.start));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }

        return true;
    }
}