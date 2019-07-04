// 翻转两次链表
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        l1 = reverse(l1);
        l2 = reverse(l2);

        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            head.next = new ListNode(sum % 10);
            head = head.next;
            carry = sum / 10;
        }
        if (carry != 0) {
            head.next = new ListNode(carry);
        }

        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
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
}

//使用Stack结构做逆序并且让链表从后向前增长
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        // while (!s2.isEmpty()) {
        //     System.out.println(s2.pop());
        // }
        int sum = 0;
        ListNode curr = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            sum = sum / 10; // 这里直接通过sum / 10 求carry位的值
            if (!s1.isEmpty()) {
                l1 = s1.pop();
                sum += l1.val;
            }
            if (!s2.isEmpty()) {
                l2 = s2.pop();
                sum += l2.val;
            }
            curr.val = sum % 10;
            // System.out.println("curr: " + curr.val);
            ListNode head = new ListNode(sum / 10);
            // System.out.println("head: " + head.val);
            // 这里的head是进位, curr是当前位
            head.next = curr;
            curr = head;
        }

        return curr.val == 0 ? curr.next : curr;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        ListNode curr = new ListNode(0);
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int sum = carry;
            if (!s1.isEmpty()) {
                l1 = s1.pop();
                sum += l1.val;
            }
            if (!s2.isEmpty()) {
                l2 = s2.pop();
                sum += l2.val;
            }
            curr.val = sum % 10;
            carry = sum / 10;
            ListNode head = new ListNode(carry);
            head.next = curr;
            curr = head;
        }

        return curr.val == 0 ? curr.next : curr;
    }
}
