
/*
有问题的地方： helper()pass的参数
需要解决了一个list提前结束的问题 + 进位的问题

*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return
        }
        ListNode result = new ListNode(0);

        result.next = helper(l1.next, l2.next. carry);
    }

    public ListNode helper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null || l2 == null) {
            return l1;
        }
        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0;
        ListNode curr = new ListNode(0);
        ListNode dummy = curr;
        while (l1 != null && l2 != null) {
            curr.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10; //注意要将carry位加入计算
            curr = curr.next;
            l1 = l1.next; //注意更新l1 和 l2的指针
            l2 = l2.next;
        }
        while (l1 == null && l2 != null) {
            curr.next = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            curr = curr.next;
            l2 = l2.next;
        }
        while (l2 == null && l1 != null) {
            curr.next = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            curr = curr.next;
            l1 = l1.next;
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}

//优化while循环
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
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

        return dummy.next;
    }
}
