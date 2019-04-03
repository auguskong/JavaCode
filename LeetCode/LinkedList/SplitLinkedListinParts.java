/**
*
* Date: 05/27/18
*	Objective: 学习如何整合 余数和除数
* Des: Given a (singly) linked list with head node root, 
*	write a function to split the linked list into 
*	k consecutive linked list "parts".
*
* The length of each part should be as equal as possible
*
*/

class Solution {
	public ListNode[] splitListToParts(ListNode root, int k) {
		ListNode[] parts = new ListNode[k];
		int len = 0;
		for (ListNode node = root; node != null; node = node.next) {
			len++;
		}
		int n = len / k; //number of parts not null
		int r = len % k; //num of elements in last part or the total number of [1]

		//如何处理多种可能性， 将这种可能性包含在代码当中 
		ListNode node = root, prev = null;

		//这个循环是用来分part
		for (int i = 0; node != null && i < k; i++, r--) {
			//先添加整个链表，然后再做切割
			parts[i] = node; 
			//下一个循环用来得到合适长度的元素 
			for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
				prev = node;
				node = node.next;
			}
			//截断
			prev.next = null;
		} 
		return parts;
	}
}