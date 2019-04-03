class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums == null || nums.length == 0) {
            return result;
        }
        //declare an used array here.
        boolean[] used = new boolean[nums.length];
        backtrack(nums, result, new ArrayList(), 0, used);
        return result;
    }
    
    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> list, int start, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList(list));
        }
        //loop start from the 0, so we can back to the element in the front
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                backtrack(nums, result, list, start + 1, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}