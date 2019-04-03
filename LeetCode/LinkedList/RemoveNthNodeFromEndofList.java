/**
*
* Date: 05/29/18
* Notes: 1. fast and slow pointer must start from the dummy node
						because it my delete the first head node
*
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        //为什么fast要从dummy开始? -> A: may delete the head node
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}