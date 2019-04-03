/**
* Date: 05/27/18
* Des: Given a singly linked list, group all odd nodes 
* together followed by the even nodes.
* Objective: 如果要保证O(1)的空间复杂度，只可能完成指针的重定向
* 而不能靠node元素的复制粘贴来完成。
*
*/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head; 
        ListNode even = head.next;
        //必须要用一个头结点 来固定当前的evenHead!!
        ListNode evenHead = even;
        
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        
        return head;
    }
}