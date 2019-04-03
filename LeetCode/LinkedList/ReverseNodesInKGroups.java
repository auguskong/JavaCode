/**
* Date: 06/03/18
*
* Objective: reverse must have a prev to store the linked list location
*
*/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        // here: use while loop to loop through the whole linked list
        while (head.next != null) {
            head = reverseNextK(head, k);
        }
        
        
        return dummy.next;
    }
    
    public ListNode reverseNextK(ListNode head, int k) {
        ListNode next = head;
        for (int i = 0; i < k; i++) {
        	//here: check for next.next
            if (next.next == null) {
                return next;
            }
            next = next.next;
        }
        
        ListNode prev = head;
        ListNode p1 = head.next;
        ListNode curr = p1;
        for (int i = 0; i < k; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        head.next = prev;
        p1.next = curr;
        
        return p1;
    }
}