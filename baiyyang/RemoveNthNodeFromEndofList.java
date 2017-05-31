package baiyyang;

public class RemoveNthNodeFromEndofList {
	
	static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0 ;
        int first = 0;
        int flag = 0;
        ListNode end = head;        
        ListNode pre = null;
        ListNode current = head;          
        while(end != null && count < n){        	
        	end = end.next;        
        	count++;
        }       
        if(count < n)
        	return head;
        while(end != null){
        	flag = 1;
        	end = end.next;
        	current = current.next;
        	first++;
        	if(first>1)
        		pre = pre.next;
        	else {
				pre = head;
			}
        }
        if(flag == 0)
        	return current.next;
        if(pre == null)
        	return current;
        else {
        	pre.next = current.next;
            return head;
		}
        
    }
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		ListNode node1 = new ListNode(2);
		//node.next = node1;
		ListNode ansListNode = removeNthFromEnd(node, 3);
		while (ansListNode!=null) {
			System.out.println(ansListNode.val);
			ansListNode = ansListNode.next;
			
		}
	}

}
