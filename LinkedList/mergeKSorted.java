package LinkedList;

import java.util.PriorityQueue;

public class mergeKSorted {
	public ListNode mergeKLists(ListNode[] a) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < a.length; i++) {
			ListNode temp = a[i];
			while (temp != null) {
				pq.add(temp.val);
				temp = temp.next;
			}
		}
		ListNode head = null, curr = null;
		while (!pq.isEmpty()) {
			if (head == null) {
				head = curr = new ListNode(pq.poll());
			} else {
				curr.next = new ListNode(pq.poll());
				curr = curr.next;
			}
		}
		return head;

	}
}
