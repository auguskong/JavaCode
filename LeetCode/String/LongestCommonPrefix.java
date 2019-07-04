/*
踩坑:

1. indexOf()方法的定义
Returns the index within this string of the first occurrence of the specified substring.
The returned index is the smallest value k for which:

this.startsWith(str, k)

If no such value of k exists, then -1 is returned.

栗子: s1 = "flower"

s1.indexOf("fl")
输出: 0

s1.indexOf("lo")
输出: 1

s1.indexOf("jke")
输出: -1

2.str长度过短 爆栈的问题
pre = pre.substring(i -1)  而不能写为 pre = str.substring(i - 1)
i - 1在当前str的范围内不代表也在下一个str的范围内

*/

class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        int i = strs[0].length();
        for (String str : strs) {
            if (str.indexOf(pre) == 0) {
                continue;
            }
            else {
                while (str.indexOf(pre) != 0 && i >= 0) {
                    i--;
                    // System.out.println("i: " + i);
                    pre = pre.substring(0, i + 1);
                    // System.out.println("pre: " + pre);
                    // System.out.println("str.indexOf(pre): " + str.indexOf(pre));
                }
            }
            if (pre.equals("")) {
                return "";
            }
        }
        return pre;
    }

    // 参考: 另一种解法 使用i来定位str pre = pre.substring(0, pre.length() - 1) 更新
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }
}

