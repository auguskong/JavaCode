
/**
* Date: 11/25/2018
* Type: Array
* 细节: 使用prefix sum可以来维持正向遍历
sum[i, j] = sum[0, j] - sum[0, i - 1]
*/
public class Solution {
	public int subarraySum(int[] nums, int k) {
		int sum = 0, result = 0;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			// what is sum - k?? -> A: sum - (sum - k) == k
			// so, if (sum - k) exist, it means there is a subarray equals k
			if (preSum.containsKey(sum - k)) {
				result += preSum.get(sum - k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}

		return result;
	}
}

class Solution {
    public int subarraySum(int[] nums, int k) {
        //key: sum value: frequency
        Map<Integer, Integer> map = new HashMap<>();
        /* sum[0 : i - 1] + sum[i : j] = sum[0 : j]
        *  a + b = c
        *  a 和 c 都能顺序遍历得到 b = c - a  b == k -> count + 1 a的频率被记录在map当中能够通过快速查找得到
        * sum[i : j] == k的个数 sum[0 : i - 1] == sum[0 : j] - k的个数
        */
        //必须要有的一步初始化否则会忽略掉第一个出现的正确结果
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return count;
    }
}