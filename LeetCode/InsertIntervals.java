/*Wrong Answer: 
Don't consider the merge situation, only focus no merge situation
*/
class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> results = new LinkedList();
		int insertIndex = 0; //the index the newInterval will be sorted

		int size = intervals.size();
		for (int i = 0; i < size; i++) {
			Interval interval = intervals.get(i);
			//the smallest
			if (interval.start > newInterval.end) {
				newInterval.start = Math.min(interval.start, newInterval.start);
			}
			//can not be the first element
			else {
				insertIndex++;
				results.add(interval);
			}
			if (interval.end < newInterval.start) {
				results.add(interval);
			}
			else {
				newInterval.end = Math.max(interval.end, newInterval.end);
			}
		}
		results.add(insertIndex, newInterval); 
		return results;
	}
}

class Solution {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> results = new LinkedList();
		int insertIndex = 0; //the index the newInterval will be sorted

		int size = intervals.size();
		for (int i = 0; i < size; i++) {
			Interval interval = intervals.get(i);
			//the smallest
			if (interval.end >= newInterval.start) {
				newInterval.start = Math.min(interval.start, newInterval.start);
			}
			//can not be the first element
			else {
				insertIndex++;
				results.add(interval);
			}
			if (interval.start <= newInterval.end) {
				newInterval.end = Math.max(interval.end, newInterval.end);
			}
			else {
				results.add(interval);
			}
		}
		results.add(insertIndex, newInterval); 
		return results;
	}
}

