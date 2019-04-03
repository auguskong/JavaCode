public class OddIncreaseEvenDecrease{

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode[] getLists(ListNode head) {
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        ListNode[] nodes = new ListNode[2];
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        nodes[0] = head;
        nodes[1] = evenHead;

        return nodes;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // merge two sorted list
    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode head = init();
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            curr = curr.next;
        }
        ListNode[] nodes = getLists(head);

        ListNode odd = nodes[0];
        ListNode even = nodes[1];
        even = reverse(even);
        head = merge(odd, even);
        System.out.println(" \nAfter sorting: ");
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }

    public static ListNode init(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        return node1;
    }
}