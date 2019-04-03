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

	//define the recursion: find all the subset start with the nums[start] and output to results
	private void helper(List<List<Integer>> results,
											List<Integer> subset,
											int[] nums,
											int start) {
		//2. 递归的拆解 deep copy -> create new subset ArrayList
		//每一层都加当前的新元素
		/*
		添加顺序: [] [1] [1,2] [1,2,3] [1,3] [2] [2,3] [3]
		*/

		results.add(new ArrayList(subset));
		for (int i = 0; i < nums.length; i++) {
			//[] -> [1] or [1] -> [1, 2]
			subset.add(nums[i]);
			helper(results, subset, nums, i + 1);
			subset.remove(subset.size() - 1);
		}
	}
	//[] [3] [2] [2, 3] [1] [1, 3] [1, 2] [1, 2, 3]
	private void dfs(int[] nums, List<List<Integer>> res, List<Integer> curr, int start) {
        if (start == nums.length) {
            System.out.println(curr);
            res.add(new ArrayList(curr));
        } else {
            dfs(nums, res, curr, start + 1);
            curr.add(nums[start]);
            dfs(nums, res, curr, start + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
