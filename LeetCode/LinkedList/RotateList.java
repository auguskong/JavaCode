/**
* Date: 05/29/18
*
*
*
*/

class Solution {
	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || head.next == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy, slow = dummy;

		int len;
		for (len = 0; fast.next != null; len++) {
			fast = fast.next;
		}

		//slow points to the offset of the list
		for (int j = len - n % len; j > 0; j--) {
			slow = slow.next;
		}

		fast.next = dummy.next; //尾巴连到头结点
		dummy.next = slow.next;
		// 1 - 2 - 3 - 4 - 5 先让 5连上1, 再让dummy 连上4
		// 4 - 5 - 1 - 2 - 3
		slow.next = null; //封掉尾巴
	}
}