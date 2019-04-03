/*
* Date: 10/24/2018
* Type: LinkedList
* 数据结构: 两个dummy node + 两个遍历用的ListNode
*/

class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy;
        ListNode right = rightDummy;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }

        left.next = rightDummy.next;
        /**
        * @错点: 此处必须将right.nect指向null来结束链表，否则会有memory exceeded错误
        * 因为链表没有终止,会出现一个环,在更新ListNode的过程中，因为是重定向而不是
        * new 一个新的ListNode, node.next不会是默认的空值null,而会保留原来的指向
        * L: 1->4->3->2->5->2 n: 3  1->2->2->4->3->5
                                           \       /
                                            -------
        */
        right.next = null;

        return leftDummy.next;
    }
}