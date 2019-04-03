/*
* Description: 每个位置的字符有两种选择, 如果为数字就不做修改, 如果为字母就小写变大写, 大写变小写
* Type: Backtracking
* Date: 01/05/2019
*/

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new LinkedList<>();
        char[] array = s.toCharArray();
        permutate(array, 0, res);

        return res;
    }

    private void permutate(char[] array, int pos, List<String> res) {
        if (pos == array.length) {
            res.add(String.valueOf(array));
        }
        else {
            // permutate current digit
            permutate(array, pos + 1, res)

            // convert the current letter
            char old = array[pos];
            if (old >= 'A' && old <= 'Z') {
                array[pos] += 32;
                // do the following convert based on the new permutation
                permutate(array, pos + 1, res);
                array[pos] = old;
            } else if (old >= 'a' && old <= 'z') {
                array[pos] -= 32;
                permutate(array, pos + 1, res);
                array[pos] = old;
            }
        }
    }
}