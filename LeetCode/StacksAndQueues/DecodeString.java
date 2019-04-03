/**
*Date: 05/19/18
*
*
*/

public class Solution {
	public String decodeString(String s) {
		String res = "";
		Stack<Integer> countStack = new Stack<>();
		Stack<String> resStack = new Stack<>();

		int i = 0;
		int count = 0;
		while (i < s.length()) {
			if (Character.isDigit(s.charAt(i))) {
				int count = 0;

				while (Character.isDigit(s.charAt(i))) {
					//for more than two digits number
					count = 10 * count + (s.charAt(i) - '0');
					i++;
				}
				countStack.push(count);
			}
			else if (s.charAt(i) == '[') {
				//将 `[` 前后的字符隔离 push 
				resStack.push(res);
				res = "";
				i++;
			}
			else if (s.charAt(i) == ']') {
				StringBuilder temp = new StringBuilder(resStack.pop());
				int repeatTimes = countStack.pop();
				for (int i = 0; i < repeatTimes; i++) {
					temp.append(res);
				}
				res = temp.toString();
				i++;
			}
			else {
				res += s.charAt(i++);
			}
		}
		return res;
	}
}