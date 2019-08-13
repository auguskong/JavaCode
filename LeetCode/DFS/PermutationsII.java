// Solution1: 使用start index变量来辅助
class Solution {
    int count = 0;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, res, new ArrayList<>(), 0, used);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> level, int start, boolean[] used) {

        if (start == nums.length) {
            res.add(new ArrayList(level));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            level.add(nums[i]);
                used[i] = true;
                helper(nums, res, level, start + 1, used);
                level.remove(level.size() - 1);
                used[i] = false;
        }
    }
}

//Solution2: 不使用start index变量
class Solution {
    int count = 0;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, res, new ArrayList<>(), used);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> level, boolean[] used) {
        if (level.size() == nums.length) {
            res.add(new ArrayList(level));
            return;
        }
        // 对于[1,1,2]的test case
        // used[1] 只删除9个case 而不是21个 因为可能会从中间层停止调用
        for (int i = 0; i < nums.length; i++) {
            // 这里因为都是从第一个元素nums[0]开始遍历的,所以是需要用used数组来记录元素的使用情况
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            level.add(nums[i]);
            used[i] = true;
            helper(nums, res, level, used);
            level.remove(level.size() - 1);
            used[i] = false;
        }
    }
}

// ================================================================
/*
nums=[1,1,2] 返回的结果是[[1,1,2],[1,2],[2]]
*/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, res, new ArrayList<>(), 0, used);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> level, int start, boolean[] used) {
        if (start == nums.length) {
            res.add(new ArrayList(level));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            level.add(nums[i]);
            used[i] = true;
            helper(nums, res, level, i + 1, used);// 这里有问题！！！会提前终止递归
            level.remove(level.size() - 1);
            used[i] = false;
        }
    }
}

// ================================================================
Your input
[1,1,2]
Output
[[1,1,2],[1,2,1],[2,1,1],[2,1,1]]
Expected
[[1,1,2],[1,2,1],[2,1,1]]
// 为什么只有[2,1,1]重复出现了两次 ??
Your input
[1,1,1,2]
Output
[[1,1,1,2],[1,1,2,1],[1,2,1,1],[1,2,1,1],[2,1,1,1],[2,1,1,1],[2,1,1,1],[2,1,1,1]]
Expected
[[1,1,1,2],[1,1,2,1],[1,2,1,1],[2,1,1,1]]
// 为什么[2,1,1,1] 出现了四次 [1,2,1,1] 出现了两次?

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, res, new ArrayList<>(), 0, used);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> level, int start, boolean[] used) {
        if (level.size() == nums.length) {
            res.add(new ArrayList(level));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            if (!used[i]) {
                level.add(nums[i]);
                used[i] = true;
                helper(nums, res, level, i + 1, used);
                level.remove(level.size() - 1);
                used[i] = false;
            }
        }
    }
}

// =================================================================
Your input
[1,3,2]
stdout
15
15
Output
[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Expected
[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Your input
[1,1,2]
stdout
6
4
Output
[]
Expected
[[1,1,2],[1,2,1],[2,1,1]]

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, res, new ArrayList<>(), 0, used);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> level, int start, boolean[] used) {
        if (level.size() == nums.length) {
            res.add(new ArrayList(level));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            level.add(nums[i]);
            used[i] = true;
            helper(nums, res, level, i + 1, used);
            level.remove(level.size() - 1);
            used[i] = false;
        }
    }
}
