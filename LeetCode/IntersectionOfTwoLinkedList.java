/*
* Date: 10/25/2018
*
*
*
*/

/* Trick 版本
*
*
*
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //错点：头指针没有被保留，更新之后已经不是原来的头指针了！！
        while (headA != headB) {
            headA = headA == null ? headB : headA.next;
            headB = headB == null ? headA : headB.next;
        }

        return headA;
    }
}

@Override
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //用两个新的指针来保留头结点
        ListNode pA = headA;
        ListNode pB = headB;

        while (headA != headB) {
            headA = headA == null ? pB : headA.next;
            headB = headB == null ? pA : headB.next;
        }

        return headA;
    }
}

/*
* 最简单的解法：先算两个链表的长度，减差值来保证同一起点起跑
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = 0;
        int lenB = 0;

        ListNode curr = headA;
        while (curr != null) {
            curr = curr.next;
            lenA++;
        }

        curr = headB;
        while (curr != null) {
            curr = curr.next;
            lenB++;
        }

        int diff = (lenA > lenB) ? lenA - lenB : lenB - lenA;
        if (lenA > lenB) {
            for (int i = 0; i < diff; i++) {
                headA = headA.next;
            }
        }
        else {
            for (int i = 0; i < diff; i++) {
                headB = headB.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        if (headA == headB) {
            return headA;
        }

        return null;
    }
}