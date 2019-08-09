// 题目: Given a collection of candidate numbers (candidates) and a target number (target),
// find all unique combinations in candidates where the candidate numbers sums to target.

// 同一个数字可以重复使用unlimited times
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        dfs(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int remain, List<List<Integer>> res, List<Integer> level, int start) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            res.add(new ArrayList(level));
        }
        for (int i = start; i < candidates.length; i++) {
            level.add(candidates[i]);
            remain = remain - candidates[i];
            dfs(candidates, remain, res, level, i);
            remain = remain + candidates[i];
            level.remove(level.size() - 1);
        }
    }
}