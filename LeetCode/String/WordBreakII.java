/*
* 07.24 
* DFS + memorization search
*/

class Solution {
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> res = new ArrayList<>();
		Map<String, ArrayList<String>> memo = new HashMap<>();
		return wordBreakHelper(s, wordDict, memo);
	}

	// The helper function return the list of the substring() after current s?
	private ArrayList<String> wordBreakHelper(String s, 
																						List<String> dict, 
																						Map<String, ArrayList<String>> memo) {
		if (memo.containsKey(s)) {
			return memo.get(s);
		}
		// Each result list is a new one? 就是直接的最终结果
		ArrayList<String> results = new ArrayList<String>();

		// 最后遍历到出口的时候， 直接返回空列表[]
		if (s.length() == 0) {
			return results;
		}

		if (dict.contains(s)) {
			results.add(s); 
		}

		for (int len = 1; len < s.length(); len++) {
			String word = s.substring(0, len);
			if (!dict.contains(word)) {
				continue;
			}
			String suffix = s.substring(len);
			//segmentations 得到的是suffix 字符之后的字符可以切分的List结果
			ArrayList<String> segmentations = wordBreakHelper(suffix, dict, memo);

			for (String segmentation : segmentations) {
				results.add(word + " " + segmentation);
			}
		}

		memo.put(s, results);
		return results;
	}
}