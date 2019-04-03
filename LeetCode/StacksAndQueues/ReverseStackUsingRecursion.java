
public static int getAndRemoveLastElement(Stack<Integer> stack) {
	int result = stack.pop();
	if (stack.isEmpty()) {
		//递归的出口：stack 是空栈
		return result;
	} else {
		int last = getAndRemoveLastElement(stack);
		stack.push(result);
		return last;
	}
}

//递归的调用关键在于程序的执行顺序
public static void reverse(Stack<Integer> stack) {
	//递归的出口：stack 是空栈
	if (stack.isEmpty()) { 
		return;
	}
	int i = getAndRemoveLastElement(stack);

	reverse(stack);

	stack.push(i);
}
