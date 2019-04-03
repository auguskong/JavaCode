/** 
* Date: 05/23/18
*
*
*/

//Using stack
public int[] dailyTemperatures(int[] temperatures) {
	Stack<Integer> stack = new Stack<Integer>();
	int[] res = new int[temperatures.length];
	for (int i = 0; i < temperatures.length; i++) {
		while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
			int idx = stack.pop();
			res[idx] = i - idx;
		}
		//push every index to the stack
		stack.push(i); 
	}
	return res;
}

//Using array faster
public int[] dailyTemperatures(int[] temperatures) {
	int[] stack = new int[temperatures.length];
	int top = -1;
	int[] res = new int[temperatures.length];
	for (int i = 0; i < temperatures.length; i++) {
		while (top > - 1 && temperatures[i] > temperatures[stack[pop]]) {
			int idx = stack[top--];
			res[idx] = i - idx;
		}
		stack[++top] = i;
	}
	return res;
}