Submission Result: Wrong Answer 
Input:
[1,1,1]
Output:
[1,1]
Expected:
[1]

//Null Pointer Error
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            if (head.val == prev.val) {
                prev.next = head.next;
            }
            prev = prev.next;
            head = head.next;
        }
        
        return dummy.next;
    }
}

//Pay attention to the corner case!!!!
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode list = head;
         while(list.next != null) 
         {
             if (list.val == list.next.val)
                 list.next = list.next.next;
             else 
                 list = list.next;
         }
         return head;
    }
}
