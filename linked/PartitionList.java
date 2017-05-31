package linked;

import java.time.Period;

import linked.ReorderList.ListNode;

public class PartitionList {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	 }
	
	public static ListNode partition(ListNode head, int x) {
		ListNode h1 = new ListNode(0);
		ListNode h2 = new ListNode(0);
		ListNode p = h1;
		ListNode q = h2;
		while(head != null){
			if(head.val < x){
				p.next = head;
				p = p.next;				
			}else {
				q.next = head;
				q = q.next;				
			}
			head = head.next;
		}
		p.next = null;
		q.next = null;
		p.next = h2.next;
		return h1.next;						
    }
	
	public static void main(String[] args) {
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(6);
		ListNode d = new ListNode(4);
		a.next = b;
		//b.next = c;
		//c.next = d;
		ListNode ans = partition(a,2);
		while(ans != null){
			System.out.println(ans.val);
			ans = ans.next;
		}
	}
}
