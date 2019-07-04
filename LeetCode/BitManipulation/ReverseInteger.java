class Solution {
    public int reverse(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10; //依次返回 个 -> 十 -> 百
            int newResult = result * 10 + tail;
            // System.out.println("x: " + x);
            // System.out.println("tail: " + tail);
            // System.out.println("newResult: " + newResult);
            // System.out.println("result: " + result);

            // 用来处理数字溢出的情况(题目要求的是32-bit Integer 上限是2^10)
            // newResult = result * 10 + tail的逆操作
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}