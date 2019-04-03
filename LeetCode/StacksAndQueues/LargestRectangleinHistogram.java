/**
* Date: 05/24/18
*
*
* Q: why we need i--??
*/

public class Solution {
	public int largestRectangleArea(int[] heights) {
		int len = heights.length;
		//Use Stack to store the index of the heights
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i <= len; i++) {
			int h = (i == len ? 0 : heights[i]);
			if (stack.isEmpty() || h >= heights[stack.peek()]) {
				stack.push(i);
			} else {
				int left = stack.pop();
				if (stack.isEmpty()) {
					maxArea = Math.max(maxArea, heights[left] * i);
					i--; 
				} else {
					maxArea = Math.max(maxArea, heights[left] * (i - 1 - stack.peek()));
					i--;
				}
			}
		}
		return maxArea;
	}
}

//improvement no i--
public class Solution {
	public int largestRectangleArea(int[] heights) {
		int len = heights.length;
		//Use Stack to store the index of the heights
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i <= len; i++) {
			int h = (i == len ? 0 : heights[i]);
			while (!stack.isEmpty() && h < heights[stack.peek()]) {
				int height = heights[stack.pop()];
				int left = stack.isEmpty() ? -1 : stack.peek();
				int area = height * (i - left - 1);
				maxArea = Math.max(maxArea, area);
			}
			stack.push(i);
		}
		return maxArea;
	}
}