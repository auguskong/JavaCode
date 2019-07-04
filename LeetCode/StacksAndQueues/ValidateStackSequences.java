class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int ele : pushed) {
            stack.push(ele);
            // System.out.println("peek: " + stack.peek());
            // System.out.println("popped[i]: " + popped[i]);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                //当stack.peek() == popped[i]的时候必须要弹出,否则就会出现对不上号的情况
                stack.pop();
                i++;
            }
            // System.out.println("i: " + i);
        }

        return i == popped.length;
    }
}