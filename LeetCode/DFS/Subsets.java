/*
For backtracking questions, consider the follow questions:
1. how to keep the current track?
2. how to output the current track?
*/

public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		Arrays.sort(nums);
		helper(results, new ArrayList<>(), nums, 0);
		return results;
	}

	//[] [3] [2] [2, 3] [1] [1, 3] [1, 2] [1, 2, 3]
	private void dfs(int[] nums, List<List<Integer>> res, List<Integer> curr, int start) {
        if (start == nums.length) { // 出口:
            System.out.println(curr);
            res.add(new ArrayList(curr)); // deep copy -> create new ArrayList
        } else {
            dfs(nums, res, curr, start + 1);
            curr.add(nums[start]);
            dfs(nums, res, curr, start + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
