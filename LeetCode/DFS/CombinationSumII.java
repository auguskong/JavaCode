class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }
    
    public void helper(int[] candidates, int remain, List<List<Integer>> result, List<Integer> temp, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (remain < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //avoid repeated 
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            temp.add(candidates[i]);
            helper(candidates, remain - candidates[i], result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}