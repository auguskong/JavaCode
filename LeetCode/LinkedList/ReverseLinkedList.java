
// recursive solution
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode curr) {
        if (curr == null) {
            return prev;
        }
        ListNode nextHead = curr.next;
        curr.next = prev;
        return reverse(curr, nextHead);
    }
}