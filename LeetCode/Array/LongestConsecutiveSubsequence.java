

public class Solution {

    // O(NlogN) 排序 + 直接遍历搜索 更新左边界
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);//O(nlgn);
        int curr = nums[0];
        int sum = 1;
        int ans = 1;
        for(int i = 1;i< nums.length;i++){
            if(nums[i] == nums[i - 1]) continue;
            if(nums[i] == curr + 1){
                curr++;
                sum++;
                ans = Math.max(ans,sum);
            }else{
                curr = nums[i];
                sum = 1;
            }
        }
        return ans;
    }

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int ans = 0;
        for(int num : nums) {
            // 这里的指针指的不是位置而是数值
            int left = num - 1;
            int right = num + 1;
            while(set.remove(left)) left--;
            while(set.remove(right)) right++;
            ans = Math.max(ans,right - left - 1);
            if(set.isEmpty()) return ans;//save time if there are items in nums, but no item in hashset.
        }
        return ans;
    }
}

// 比较好理解的实现 remove是必须要有的 如果没有remove相当于O(n^2)的实现[1,2,3,4,5]
// 每个元素都会遍历一遍整个数组
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int item : nums) {
            if (set.contains(item)) {
                int left = item - 1;
                int right = item + 1;
                while (set.contains(left)) {
                    set.remove(left);
                    left--;
                }
                while (set.contains(right)) {
                    set.remove(right);
                    right++;
                }
                res = Math.max(right - left - 1, res);
            }
        }

        return res;
    }
}


