class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        char[] numsLeft = new char[]{'0','1','8','6','9'};
        char[] numsRight = new char[]{'0','1','8','9','6'};
        char[] number = new char[n];
        dfs(res, numsLeft, numsRight, number, 0);

        return res;
    }

    private void dfs(List<String> res, char[] numsLeft, char[] numsRight, char[] number, int index) {
        int left = index;
        int right = number.length - index - 1;
        if (left > right) {
            res.add(new String(number));
            return;
        }
        if (left == right) {
            // 只加一边
            for (int i = 0; i < 3; i++) {
                number[left] = numsLeft[i];
                dfs(res, numsLeft, numsRight, number, index + 1);
            }
        } else {
            // 左右两边同时加新元素 保持对称
            for (int i = 0; i < numsLeft.length; i++) {
                if(index == 0 && i == 0) continue;//跳过leading 0 开头的数字
                number[left] = numsLeft[i];
                number[right] = numsRight[i];
                dfs(res, numsLeft, numsRight, number, index + 1);
            }
        }
    }
}