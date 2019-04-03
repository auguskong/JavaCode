/*
1. flattenList() encapsulation
2. learn to use the provided methods isInteger() getInteger() getList()
3. 
*/

public class NestedIterator implements Iterator<Integer> {
	private Stack<NestedInteger> stack;

	public NestedIterator(List<NestedInteger> nestedList) {
		stack = new Stack<>();
		flattenList(nestedList);
	}

	@Override
	public Integer next() {
		return hasNext() ? stack.pop().getInteger() : null;
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			if (stack.peek().isInteger()) return true;
			flattenList(stack.pop().getList()); 
			//built-in function getList() return NestedList when there is a list
		}
		return false;
	}

	private void flattenList(List<NestedInteger> list) {
		for (int i = list.size() - 1; i >= 0; i--) {
			stack.push(list.get(i));
		}
	}
}