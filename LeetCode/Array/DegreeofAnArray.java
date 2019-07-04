/**
* Date: 11/13/2018

* 题目描述: 定义一个数组的度数为数组中出现次数最多的的那个数的出现次数, 返回和度数相同的
最短子数组的长度
* Algorithm:
* 题目的本质是找到出现频率最大的那个数第一次出现的位置和最后一次出现的位置
* 先用hashmap 统计频率 然后再用binary search 第一次出现的位置 和 最后一次出现的位置
*/

// 别人的答案: 用两个hashmap 分别记录 出现频率 以及 第一次出现的index 针对当前度数 > 最大度数
// 以及当前度数 == 最大度数时 分别进行结果的更新操作
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>()
        Map<Integer, Integer> first = new HashMap<>();
        int res = 0, degree = 0;
        for (int i = 0; i < nums.length; ++i) {
            first.putIfAbsent(nums[i], i);
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
            if (counter.get(nums[i]) > degree) {
                degree = counter.get(nums[i]);
                res = i - first.get(nums[i]) + 1;
            } else if (counter.get(nums[i]) == degree)
                res = Math.min(res, i - first.get(nums[i]) + 1);
        }
        return res;
    }
}


