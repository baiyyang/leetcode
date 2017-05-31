package baiyyang;

public class MergeTwoSortedLists {

	static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode ans = p;                
        while(l1!=null && l2!=null){
        	if(l1.val >= l2.val){
        		p.next = l2;
        		p = p.next;
        		l2 = l2.next;
        	}
        	else {
        		p.next = l1;
        		p = p.next;
				l1 = l1.next;
			}
        }
        if(l1 != null){
        	p.next = l1;    		
        }
        if(l2 != null){
        	p.next = l2;    		
        }        
        return ans.next;
        
    }
	
	public static void main(String[] args) {
		System.out.println(mergeTwoLists(null, new ListNode(0)));
	}
	
}
