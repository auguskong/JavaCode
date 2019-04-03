
//03.25 重做 -- 残次品
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy =new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null) {
            if (prev.next.val = m) {
                int length = getLength()
                reverse(prev, )
            }
        }   
    }
    
    public void reverse(ListNode start, ListNode end) {
        if (head == null) {
            return;
        }
        ListNode prev = start;
        ListNode curr = start.next;
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        if (curr)
    }
    
    public int getLength(ListNode head) {
        int count = 0;
        while(head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}

//basketwang's elegent code
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode mNode = head;
        ListNode preM = dummy;
        ListNode nNode = head;
        for (int i = 1; i < m; i++) {
            preM = mNode;
            mNode = mNode.next;
        }
        for (int i = 1; i < n; i++) {
            nNode = nNode.next;
        }

        while(mNode != nNode) {
            preM.next = mNode.next;
            mNode.next = nNode.next;
            nNode.next = mNode;
            mNode = preM.next;
        }
        return dummy.next;
    }
}