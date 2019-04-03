class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        helper(nums, res, new ArrayList<Integer>(), 0);

        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> level, int start) {
        res.add(new ArrayList(level));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            level.add(nums[i]);
            // 错点: 这个地方用了 start + 1所以每次递归都没有往下走, 而是从第二个元素开始走
            /*
            在for loop外添加打印语句的结果
            []
            [1]
            [1, 2]
            [1, 2, 3]
            [1, 3]
            [1, 3, 3]
            [2]
            [2, 2]
            [2, 2, 3]
            [2, 3]
            [2, 3, 3]
            [3]
            [3, 2]
            [3, 2, 3]
            [3, 3]
            [3, 3, 3]
            */
            helper(nums, res, level, start + 1);
            level.remove(level.size() - 1);
        }
    }
}

class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null) return results;

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);

        List<Integer> subset = new ArrayList<Integer>();
        helper(nums, 0, subset, results);

        return results;


    }
    public void helper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results){
        results.add(new ArrayList<Integer>(subset));
        for(int i=startIndex; i<nums.length; i++){
            if (i != startIndex && nums[i]==nums[i-1]) {
                continue;
            }
            subset.add(nums[i]);
            helper(nums, i+1, subset, results);
            subset.remove(subset.size()-1);
        }
    }
}