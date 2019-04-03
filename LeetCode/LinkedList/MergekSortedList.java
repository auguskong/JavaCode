class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        for (ListNode node : lists) {
            if (node != null) {
               pq.add(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            head.next = curr;
            if (curr.next != null) {
                pq.add(curr.next);
            }
            head = head.next;
        }
        return dummy.next;
    }
}

public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }

        return mergeHelper_v1_minHeap(lists);
        // return mergeHelper_v2_Divide_Conquer(lists, 0, lists.size() - 1);
        // return mergeHelper_v3_Non_Recursive(lists);
    }

    private ListNode mergeHelper_v1_minHeap(List<ListNode> lists) {
        // initial priorityQueue
        Queue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        //
        ListNode dummy = new ListNode(0), tail = dummy;

        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            tail.next = top;
            tail = top;
            if (top.next != null) {
                pq.offer(top.next);
            }
        }

        return dummy.next;
    }

    private ListNode mergeHelper_v2_Divide_Conquer(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }

        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper_v2_Divide_Conquer(lists, start, mid);
        ListNode right = mergeHelper_v2_Divide_Conquer(lists, mid + 1, end);
        return mergeTwoSortedList(left, right);
    }

    private ListNode mergeHelper_v3_Non_Recursive(List<ListNode> lists) {
        while (lists.size() > 1) {
            // merge
            List<ListNode> tmp = new ArrayList<ListNode>();
            for (int i = 0; i < lists.size() && i + 1 < lists.size(); i += 2) {
                ListNode head = mergeTwoSortedList(lists.get(i), lists.get(i + 1));
                tmp.add(head);
            }

            if (lists.size() % 2 == 1) {
                tmp.add(lists.get(lists.size() - 1));
            }

            lists = tmp;
        }
        return lists.get(0);
    }

    private ListNode mergeTwoSortedList(ListNode L1, ListNode L2) {
        ListNode dummy = new ListNode(0), tail = dummy;

        while (L1 != null && L2 != null) {
            if (L1.val <= L2.val) {
                tail.next = L1;
                L1 = L1.next;
            } else {
                tail.next = L2;
                L2 = L2.next;
            }
            tail = tail.next;
        }

        tail.next = (L1 != null) ? L1 : L2;

        return dummy.next;
    }
}