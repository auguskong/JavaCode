/**
* Date: 11/13/2018
* Type: Array
* Data Structure:
* Algorithm: Moore Voting Algorithm
*/

public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            //错点: count是每次都需要进行判断加减的 用if而不是else if
            if (num != res) {
                count--;
            }
            else {
                count++;
            }
        }

    }


}