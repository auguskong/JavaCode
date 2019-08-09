class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> level, int k, int remain, int start) {
        if (k == 0 && remain == 0) {
            res.add(new ArrayList(level));
            return;
        }
        for (int i = start; i <= 9; i++) {
            level.add(i);
            dfs(res, level, k - 1, remain - i, i + 1);
            level.remove(level.size() - 1);
        }
    }
}