/**
* Date: 05/27/18
* Des: Given a linked list, swap every two adjacent nodes and return its head.
* 
* 1.需要使用,三个指针按照次序依次转换,必须从前往后,否则会导致链表元素的丢失
* prev.next curr.next next.next 
* 考虑链表的中间结构是general case, 链表的头部是special case, 头结点没有被一个节点指向，
* 使用dummy node来构造general case,从而可以使用while loop循环来操作整个链表元素
* 2. Swap元素是跳跃式的转换，通过`prev = curr;` 来完成，因为curr在转换之后会被换到最前面
* 
*/



class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (prev.next != null && prev.next.next != null) {
            //here create the new pointers and 
            //start change the pointer direction
            ListNode curr = prev.next;
            ListNode next = prev.next.next;
            prev.next = curr.next;
            curr.next = next.next;
            next.next = curr;
            prev = curr;
        }
        
        return dummy.next;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        //出口
        if ((head == null)||(head.next == null))
            return head;
        ListNode node = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return node;
    }
}