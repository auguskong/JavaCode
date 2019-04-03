/*
Date: 05/10/18
Author: Auguskong

Example: 
Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

lesson: dummy node is used for simplify update the pointer
*/

class Solution {
    public ListNode partition(ListNode head, int x) {
        
        ListNode dummyLeft = new ListNode(0);
        ListNode dummyRight = new ListNode(0);
        ListNode left = dummyLeft, right =dummyRight;
       
        while(head != null) {
            //System.out.println("headt.val: " + head.val);
            //System.out.println("left.val: " + left.val);
            if (head.val < x) {
                left.next = head;
                left = left.next;
            }
            else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = dummyRight.next;
        return dummyLeft.next;
    }
}