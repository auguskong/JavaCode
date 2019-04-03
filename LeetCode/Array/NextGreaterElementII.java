class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] res = new int[len];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            // 用一个取模计算来 使得数组循环起来
            for (int k = (i + 1) % len; k < len; k++) {
                if (nums[k] > curr) {
                    res[i] = nums[k];
                    break;
                }
            }
        }

        return res;
    }

    // 参考答案
    public int[] nextGreaterElements(int[] A) {
        int n = A.length
        int[]res = new int[n];
        Arrays.fill(res, -1);
        // stack 当中存的是index
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            /*[9,8,2,5,7]
            stack当中 0,1,2 -> res[2] = 5 -> 0,1,3 -> res[3] = 7 -> 0,1,4
            -> res[4] = 9 -> 0,1 -> res[1] = 9 -> 0,0 -> 0,0,1,2
            */
            while (!stack.isEmpty() && A[stack.peek()] < A[i % n])
                res[stack.pop()] = A[i % n];
            stack.push(i % n);
        }
        return res;
    }
}


