/**
* Date: 05/21/18
*	
*
*/
public class Solution {
	public int[] maxSlidingWindow(int[] a, int k) {
		if (a == null || k < 1 || a.length < k) {
			return null;
		}
		int n = a.length;
		int[] res = new int[n - k + 1];
		int index = 0;

		//The deque store the index of the array
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			//remove the number that is out of the window range
			while (!deque.isEmpty() && deque.peek() < i - k + 1) {
				deque.poll();
			}
			//remove smaller numbers inside the window
			while (!deque.isEmpty() && a[deque.peekLast()] < a[i]) {
				deque.pollLast();
			}
			deque.offer(i);
			//wait until the window have set up
			if (index >= k - 1) {
				res[index++] = a[deque.peek()];
			}
		}
		return res;
	}
}
