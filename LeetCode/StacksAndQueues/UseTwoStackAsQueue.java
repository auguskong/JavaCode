/**
* Date: 11/21/2018
*
*
*
*/
class Solution {

    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    public void push(int node) {
        s1.push(node);
    }

    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (!s2.isEmpty()) {
            return s2.pop();
        }
        return -1;
    }
}