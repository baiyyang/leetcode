package linked;

public class ReverseLinkedList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	 }
	
	public ListNode reverseList(ListNode head) {
        if(head == null)
        	return null;
        ListNode ans = head;
        ListNode p = ans.next;
        ans.next = null;
        while(p != null){
        	ListNode q = p.next;
        	p.next = ans;
        	ans = p;
        	p = q;
        }
        return ans;
    }
}
