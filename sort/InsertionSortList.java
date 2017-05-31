package sort;

public class InsertionSortList {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode insertionSortList(ListNode head) {
        if(head == null)
        	return null;
        ListNode p = head.next;
        ListNode pre = head;
        while(p != null){
        	if(pre.val > p.val){        		
				ListNode start = head;
				if(start.val > p.val){
					ListNode r = p.next;
					p.next = start;
					head = p;
					pre.next = r;
					p = r;
				}else {
					while(start.next != null){
						if(start.next.val > p.val){
							ListNode r = p.next;
							ListNode pos = start.next;
							start.next = p;
							p.next = pos;
							pre.next = r;
							p = r;
							break;
						}
						start = start.next;
					}
				}				
        	}else {
				p = p.next;
				pre = pre.next;
			}
        }
        return head;
    }
	
	public static void main(String[] args) {
		ListNode d = new ListNode(4);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(3);
		d.next = a;
		a.next = b;
		b.next = c;
		InsertionSortList sort = new InsertionSortList();
		ListNode ans = sort.insertionSortList(d);
		while(ans != null){
			System.out.println(ans.val);
			ans = ans.next;
		}
	}
}
