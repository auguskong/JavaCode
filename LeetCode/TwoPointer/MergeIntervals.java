public List<Interval> merge(List<Interval> intervals) {
	List<Interval> res = new LinkedList();
	if (intervals.size() <= 1) {
		return intervals;
	}

	int size = intervals.size();
	int[] starts = new int[size];
	int[] ends = new int[size];
	for (int i = 0; i < size; i++) {
		starts[i] = intervals[i].start; //List use get() function to get value
		ends[i] = intervals[i].end;
	}

	//sort is used for simplifying later comparision operation
	Arrays.sort(starts);
	Arrays.sort(ends);

	int i = 0;
	int j = 0;
	//use i to track the end, use j to track the start
	while (i < starts.length) {
		// 什么时候存在交叉 前一个end 在后一个的start的后面 end[i] > start[i + 1]
		// 如果有交叉还需要继续比较下一个
		if (i == starts.length - 1 || ends[i] < starts[i + 1]) {
				res.add(new Interval(starts[j], ends[i])); //add the interval
				j = i + 1; //key point!!
		}
		//else the interval can be merged, so only move i to the next end!
		i++;
		123456

		1    6
		------
		 23
		 --
		  3-5
		  ---
// 为什么排序后和排序前是等效的 因为是要进行merge操作？
		1 2 3
		3 5 6

		---
		 ----
		  ----

	}
	return res;
}


//low speed original version
public List<Interval> merge(List<Interval> intervals) {
	//corner case check
	if (intervals.size() <= 1)
		return intervals;
	//avoid using comparator
	intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

	//set the start and end to the initial element
	List<Interval> result = new LinkedList<Interval>();
	int start = intervals.get(0).start;
	int end = intervals.get(0).end;

	for (Interval interval : intervals) {
		if (interval.start <= end) {
			end = Math.max(end, interval.end);
		}
		else {
			result.add(new Interval(start, end));
			//here update
			start = interval.start;
			end = interval.end;
		}
	}

	result.add(new Interval(start, end));
	return result;
}