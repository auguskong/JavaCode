
//神回复
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
}


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        for (ListNode p = headA; p != null; p = p.next) lenA++;
        for (ListNode p = headB; p != null; p = p.next) lenB++;
        
        while (lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        
        while (lenB < lenA) {
            headA = headA.next;
            lenA--;
        }
        
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;   
    }
}