// 先遍历nums2, 找到每个数的next greater element O(n^2)
import java.util.HashMap;
class Solution {

    // 我的答案 输出有问题
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1];
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < len2 - 1; i++) {
            int curr = nums[i];
            int nextGreater = curr;
            boolean found = false;
            for (int k = i + 1; k < len2; k++) {
                if (nums2[k] > curr) {
                    map.put(i, nums2[k]);
                    break;
                }
            }
        }
        for (int i = 0; i < len1 - 1; i++) {
            res[i] = map.getOrDefault(i, -1);
        }
        res[len1 - 1] = -1;
        return res;
    }

    // 我的答案,修改过之后可以AC
    // Time O(n) Space O(n)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1];
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < len2 - 1; i++) {
            int curr = nums2[i];
            for (int k = i + 1; k < len2; k++) {
                if (nums2[k] > curr) {
                    // map里面存的是值和值 而不是index和值
                    map.put(nums2[i], nums2[k]);
                    // 注意这里要用break而不能用continue
                    break;
                }
            }
        }
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    // 参考答案
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }
}