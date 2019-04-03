/**
* Date: 16/5/18
* 完全懵逼的
*/
public class Solution { 
     public boolean isValidSerialization(String preorder) {
        if (preorder == null) {
            return false;
        }
        String[] strs = preorder.split(",");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < strs.length; i++) {
            String curr = strs[i]; //iterate all the string
            while (curr.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            stack.push(curr);
        }
        return stack.size() == 1 && stack.peek().equals("#");
     }
}