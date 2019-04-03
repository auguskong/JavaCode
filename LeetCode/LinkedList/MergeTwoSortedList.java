
Submission Result: Time Limit Exceeded 
Last executed input:
[1,2,4]
[1,3,4]
//残次品代码 逻辑错误
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        if (l1 == null) {
            curr = l2;
        }
        else if (l2 == null) {
            curr = l1;
        }
        
        dummy.next = curr;
        while(curr != null) {
            if(l1.val <= l2.val) {
                curr.next = l1;
            }
            else {
                curr.next = l2;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}

//null pointer error
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr = l1;
                l1 = l1.next;
            }
            else {
                curr = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if (l1 == null) {
            curr.next = l2;
        } else {
            curr.next = l1;
        }
        
        return dummy.next;
    }
}

//AC 代码思路 -> 1. 处理不为空的节点 2.处理空节点

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if (l1 == null) {
            curr.next = l2;
        } else {
            curr.next = l1;
        }
        
        return dummy.next;
    }
}


//没有对curr进行节点的更新 - 03.28
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null){
            curr.next = l2;
        } else {
            curr.next = l1;
        }
        
        return dummy.next;
    }
}