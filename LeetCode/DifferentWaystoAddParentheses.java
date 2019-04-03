/*
input: String "2 - 1 - 1"
*/

class Solution {
	Map<String, List<Integer>> map = new HashMap<>();
	public List<Integer> diffWaysToCompute(String input) {
		if (map.containsKey(input)) return map.get(input);
		List<Integer> res = new ArrayList();
		
		for (int i = 0; i < input.length(); i++) {
			char op = input.charAt(i);
			if (op == '+' || op == '-' || op == '*') {
				//做递归的拆解
				List<Integer> left = diffWaysToCompute(input.substring(0, i));
				List<Integer> right = diffWaysToCompute(input.substring(i + 1));
				for (int t1 : left) {
					for (int t2 : right) {
						if (op == '+') {
							res.add(t1 + t2);
						}
						else if (op == '-') {
							res.add(t1 - t2);
						}
						else {
							res.add(t1 * t2)
						}
					}
				}
			}
		}
		if (res.size() == 0) {
			res.add(Integer.parseInt(input));
		}
		map.put(input, res); //??
		return res;
	}
}