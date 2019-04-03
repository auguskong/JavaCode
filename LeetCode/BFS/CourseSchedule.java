/*CourseSchedule II
@param: int numCourses - total number of courses, int[][] prerequisites course pairs
@return:  int[] order - order of courses that need to be taken 
*/

public class Solution {
	public int[] findOrder(int numCourses, int[][] prerequisites) {

		//edges is an array of list -> save the integer[[...], [...], [...]]
		List[] edges = new ArrayList[numCourses];
		int[] degree = new int[numCourses];
		int[] order = new int[numCourses]; //store the final result

		for (int i = 0; i < numCourses; i++) {
			edges[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < prerequisites.length; i++) {
			degree[prerequisites[i][0]]++;
			edges[prerequisites[i][1]].add(prerequisites[i][0]); //why not use '=' rather than '.add'
		}

		Queue queue = new LinkedList();
		for (int i = 0; i < degree.length; i++) {
			if (degree[i] == 0) {
				queue.add(i);
			}
		}

		int count = 0;
		while (!queue.isEmpty()) {
			int course = (int)queue.poll();
			//add the course to order[] before count++ -> caution to outof index error!!
			order[count] = course; 
			//why there is an (int) because not clarify Interger type when initialize queue
			count++;
			//use for loop to decrease the degree when the course finished
			int n = edges[course].size();
			for (int i = 0; i < n; i++) {
				int pointer = (int)edges[course].get(i);
				degree[pointer]--;
				if (degree[pointer] == 0) {
					queue.add(pointer);
				}
			}
		}
		if (count == numCourses) {
			return order;
		}
		return new int[0];//caution to create new []!!
	}
}




/*
CourseSchedule I 
@param: int numCourses - total number of courses, int[][] prerequisites course pairs
@return: boolean
*/
public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {

		//edges is an array of list -> save the integer[[...], [...], [...]]
		List[] edges = new ArrayList[numCourses];
		int[] degree = new int[numCourses];

		//Must intialize before using the edges
		for (int i = 0; i < numCourses; i++) {
			edges[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < prerequisites.length; i++) {
			degree[prerequisites[i][0]]++;
			edges[prerequisites[i][1]].add(prerequisites[i][0]); //why not use '=' rather than '.add'
		}

		Queue<Integer> queue = new LinkedList();
		for (int i = 0; i < degree.length; i++) {
			if (degree[i] == 0) {
				queue.add(i);
			}
		}

		int count = 0;
		while (!queue.isEmpty()) {
			int course = queue.poll(); 
			//why there is an (int) because not clarify Interger type when initialize queue
			count++;
			//use for loop to decrease the degree when the course finished
			int n = edges[course].size();
			for (int i = 0; i < n; i++) {
				//Must change to Integer type 
				int pointer = (int)edges[course].get(i);
				degree[pointer]--;
				if (degree[pointer] == 0) {
					queue.add(pointer); //add the course not the i!!
				}
			}
		}

		return count == numCourses;
	}
}





