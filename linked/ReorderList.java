package linked;

import java.util.Stack;

public class ReorderList {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	 }
	
	public static void reorderList(ListNode head) {
        if(head != null){
        	ListNode p = head;
        	Stack<ListNode> stack = new Stack<>();
        	while(p != null){
        		stack.push(p);
        		p = p.next;
        	}
        	ListNode start = head;
        	ListNode end = stack.pop();
        	while(start != end){
        		ListNode q = start.next;
        		start.next = end;
        		if(end != q){
        			end.next = q;
        		}else {
					end.next = null;
					break;
				}
        		start = q;        		
        		end = stack.pop();
        	}
        	end.next = null;
        	
        }
        
    }
	
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		//a.next = b;
		//b.next = c;
		//c.next = d;
		reorderList(a);
		while(a != null){
			System.out.println(a.val);
			a = a.next;
		}
	}
}
