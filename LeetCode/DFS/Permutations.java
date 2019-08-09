// Input: [1,2,3]
// Output:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Permutations {
    static int[] nums;
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, res, new ArrayList<>(), used);
        return res;
    }

    private static void helper(int[] nums, List<List<Integer>> res, List<Integer> level, boolean[] used) {
        indent(level.size());
        System.out.printf("helper(%s) \n", level.toString());
        if (level.size() == nums.length) {
            indent(level.size());
            System.out.printf("Add to res and return \n");
            res.add(new ArrayList(level));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                level.add(nums[i]);
                used[i] = true;
                helper(nums, res, level, used);
                level.remove(level.size() - 1);
                used[i] = false;
            }
        }
    }

    private static void indent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("   ");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str = scan.next();
            System.out.println("输入的数据为：" + str);
            nums = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                nums[i] = c - '0';
            }
        }
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
        scan.close();
    }
}

// Use HashSet to record the used elements
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // HashSet 的contains() 和 remove
        HashSet<Integer> set = new HashSet<>();
        permute(nums, res, new ArrayList<>(), set);
        return res;
    }

    private void permute(int[] nums, List<List<Integer>> res, List<Integer> level, HashSet<Integer> set) {
        if (level.size() == nums.length) {
            res.add(new ArrayList(level));
            return;
        }
          for (int i = 0; i < nums.length; i++) {
              if (!set.contains(nums[i])) {
                level.add(nums[i]);
                set.add(nums[i]);
                permute(nums, res, level, set);
                level.remove(level.size() - 1);
                set.remove(nums[i]);
            }
        }

    }
}