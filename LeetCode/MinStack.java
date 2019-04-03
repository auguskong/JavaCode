class MinStack
{
    static class Element
    {
        final int value;
        final int min;
        Element(final int value, final int min)
        {
            this.value = value;
            this.min = min;
        }
    }
    final Stack<Element> stack = new Stack<>();
    
    public void push(int x) {
        final int min = (stack.empty()) ? x : Math.min(stack.peek().min, x);
        stack.push(new Element(x, min));
    }

    public void pop()
    {
        stack.pop();
    }

    public int top()
    {
        return stack.peek().value;
    }

    public int getMin()
    {
        return stack.peek().min;
    }
}

class MinStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> minStack; //store the min value

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        /*if (stack.isEmpty()){
            stack.push(x);
            minStack.push(x);
            return;
        }
        int min = minStack.peek();
        if (x < min) {
            minStack.push(x);
        }
        else {
            minStack.push(min);
        }
        stack.push(x);
        */
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        }
        else {
            minStack.push(Math.min(number, minStack.peek()));
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
           stack.pop();
            minStack.pop(); 
        }
        
    }
    
    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }
}
