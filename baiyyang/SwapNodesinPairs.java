package baiyyang;

import java.util.Scanner;

public class SwapNodesinPairs {
	
	static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }
	
	public static ListNode swapPairs(ListNode head) {
        ListNode ans = head;
        while(head != null){
        	ListNode temp = head.next;
        	
        }
        return ans;
    }
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		ListNode ans = swapPairs(a);
		while(ans != null){
			System.out.println(ans.val);
			ans = ans.next;
		}
	}
	
	

}
