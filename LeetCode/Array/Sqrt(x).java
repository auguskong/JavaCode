/*
In while, If mid < sqrt(x), left = mid + 1 executed, right pointer is not moving, and right is the answer.

If while, If mid > sqrt(x), right = mid - 1 executed, right pointer shifts left 1, closest to sqrt(x), right is also the answer.
*/

class Solution {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("left: " + left);
            System.out.println("right: " + right);
            System.out.println("mid: " + mid);
            if (mid == x / mid) {
                System.out.println("inside mid == x / mid");
                return mid;
            } else if (mid < x / mid) {
                System.out.println("inside mid < x / mid");
                left = mid + 1;
            } else {
                System.out.println("inside mid > x / mid");
                right = mid - 1;
            }

        }
        return right;
    }
}

/*

x = 8

left: 1
right: 8
mid: 4
inside mid > x / mid
left: 1
right: 3
mid: 2
inside mid < x / mid
left: 3
right: 3
mid: 3
inside mid > x / mid

x = 9

left: 1
right: 9
mid: 5
inside mid > x / mid
left: 1
right: 4
mid: 2
inside mid < x / mid
left: 3
right: 4
mid: 3
inside mid == x / mid

x = 13

left: 1
right: 13
mid: 7
inside mid > x / mid
left: 1
right: 6
mid: 3
inside mid < x / mid
left: 4
right: 6
mid: 5
inside mid > x / mid
left: 4
right: 4
mid: 4
inside mid > x / mid

*/