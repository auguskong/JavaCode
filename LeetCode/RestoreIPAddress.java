/*
StringBuilder sb = new StringBuilder()
sb.deleteCharAt(sb.length() - 1);  -> delete the final '.'
result.add(sb.toString()) -> convert StringBuilder to String
int digit = Integer.valueOf(s); -> 
整体思路： backtracking + construct new Stirng
边界条件： list.size() == 4
valid条件： can not start with ‘0’

*/

class Solution {
	public ArrayList<String> restoreIpAddress(String s) {
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();

		if (s.length() < 4 || s.length() > 12) {
			return result;
		}
		helper(result, list, s, 0);
		return result;
	}

	public void helper(ArrayList<String> result, ArrayList<String> list, String s, int start) {
		//递归的出口 4组数
		if (list.size() == 4) {
			if (start != s.length()) 
				return;

			StringBuffer sb = new StringBuffer();
			for (String tmp : list) {
				sb.append(tmp);
				sb.append(".");
			}
			sb.deleteCharAt(sb.length() - 1);
			result.add(sb.toString());
			return;
		}

		//递归的定义 每次尝试最多3个字符，只有第一个字符符合条件才会继续添加下去
		for (int i = start; i < s.length() && i < start + 3; i++) {
			String tmp = s.substring(start, i + 1); //start不变，i + 1向右偏移
			if (isvalid(tmp)) {
				list.add(tmp);
				helper(result, list, s, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

	private boolean isvalid(String s) {
		if (s.charAt(0) == '0') {
			return s.equals("0");
		}
		int digit = Integer.valueOf(s);
		return digit >= 0 && digit <= 255;
	}
}