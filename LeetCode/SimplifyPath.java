public class Solution {
	public String simplifyPath(String path) {

		if (path.length() <= 1) return path;
		String[] strings = path.split("/");
		Stack<String> stack = new LinkedList<String>();
		for (String s : strings){
			if (s.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
				else if (!s.equals(".") && !s.isEmpty()) {
					stack.push(s);
				}
			}
		}

		String result = "";
		if (stack.empty()) return "/";
		while (!stack.isEmpty()) {
			String newPath = stack.pop();
			result = "/" + newPath + result;
		}
		return result;
	}
}