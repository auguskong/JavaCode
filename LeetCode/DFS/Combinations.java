// 题目: Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.



public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (k > n) {
            return res;
        }
        boolean[] used = new boolean[n];
        dfs(n, k, used, res, new ArrayList<Integer>(), 1);
        return res;
    }

    private void dfs(int n, int k, boolean[] used, List<List<Integer>> res, List<Integer> curr, int start) {
        if (curr.size() == k) {
            res.add(new ArrayList(curr));
            return;
        }
        for (int i = start; i <= n; i++) {
            // 需要进行一步去重操作
            if (used[i - 1]) {
                continue;
            }
            curr.add(i);
            used[i - 1] = true;
            dfs(n, k, used, res, curr, i);
            curr.remove(curr.size() - 1);
            used[i - 1] = false;
        }
    }
}

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (k > n) {
            return res;
        }
        boolean[] used = new boolean[n];
        dfs(n, k, used, res, new ArrayList<Integer>(), 1);
        return res;
    }

    private void dfs(int n, int k, boolean[] used, List<List<Integer>> res, List<Integer> curr, int start) {
        if (k == 0) {
            res.add(new ArrayList(curr));
            return;
        }
        // 进行了剪枝操作 不需要增加去重的boolean 数组
        for (int i = start; i <= n - k + 1; i++) {
            curr.add(i);
            dfs(n, k - 1, used, res, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}