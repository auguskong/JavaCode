/**
* Date: 05/18/18
*
*
*
*/

public Stack class SortStack(Stack<Integer> stack) {

	public Stack<Integer> stackSort = new Stack<Integer>();

	while (!stack.isEmpty()) {
		int temp = stack.pop();
		while (!stackSort.isEmpty() && temp > stackSort.pop()) {
			stackSort.push(temp);
		} 
		
	}
}