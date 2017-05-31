package linked;

public class RemoveDuplicatesfromSortedList {

	 public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	 }
	 
	 public ListNode deleteDuplicates(ListNode head) {
		 if(head == null)
			 return head;
		 ListNode pre = head;
		 ListNode p = pre.next;
		 while(p != null){
			 if(pre.val == p.val){
				 p = p.next;
				 pre.next = p;
			 }else {
				pre = p;
				p = p.next;
			}
		 }
		 return head;
	 }
}
